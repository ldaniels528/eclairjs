package io.scalajs.spark

import io.scalajs.nodejs.Module.module
import io.scalajs.nodejs._
import io.scalajs.spark.sql.types.StructField
import io.scalajs.spark.sql.{Row, SparkSession}
import io.scalajs.util.PromiseHelper.Implicits._

import scala.scalajs.js
import scala.util.{Failure, Success}

/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License") you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
object Example {
  private val root = process.env.getOrElse("EXAMPLE_ROOT", __dirname + "/../..")

  def exit(): Unit = process.exit()

  def stop(e: Exception)(implicit sparkSession: SparkSession) {
    if (e != null) e.printStackTrace()
    sparkSession.stop() onComplete { _ => exit() }
  }

  def runBasicDataFrameExample(sparkSession: SparkSession, spark: Spark): js.Promise[js.Array[Row]] = {
    new js.Promise((resolve, reject) => {
      // Load a text file and convert each line to a JavaScript Object.
      val df = sparkSession.read().json(root + "/data/people.json")
      val promises = js.Array[js.Promise[_]]()

      // Displays the content of the DataFrame
      promises.push(df.take(5))

      // Select only the "name" column
      promises.push(df.select("name").take(5))

      import spark.sql.functions.col

      // Select everybody, but increment the age by 1
      promises.push(df.select(col("name"), col("age").plus(1)).take(5))

      // Select people older than 21
      promises.push(df.filter(col("age").gt(21)).take(5))

      // Count people by age
      promises.push(df.groupBy("age").count())

      // Register the DataFrame as a SQL temporary view
      df.createOrReplaceTempView("people") foreach { _ =>

        val sqlDF = sparkSession.sql("SELECT * FROM people")
        promises.push(sqlDF.take(5))

        js.Promise.all(promises) onComplete {
          case Success(v) => resolve(v)
          case Failure(e) => reject(e)
        }
      }
    })
  }
  
  def runDatasetCreationExample(sparkSession: SparkSession, spark: Spark): js.Promise[js.Array[Row]] = {
    new js.Promise((resolve, reject) => {

      // Create an instance of an object
      val person = new Person(name = "Andy", age = 32)

      // Encoders are created for Jsod
      val personEncoder = spark.sql.Encoders.json(js.Dictionary("name" -> "String", "age" -> "Integer"))

      val jsonDS = sparkSession.createDatasetFromJson[Person](js.Array(person), personEncoder)

      // Encoders for most common types are provided in class Encoders
      val integerEncoder = spark.sql.Encoders.INT()
      val primitiveDS = sparkSession.createDataset(js.Array(1, 2, 3), spark.sql.Encoders.INT())
      val transformedDS = primitiveDS.map(value => value + 1, integerEncoder)

      val promises = js.Array[js.Promise[_]]()
      promises.push(jsonDS.take(5))
      // +---+----+
      // |age|name|
      // +---+----+
      // | 32|Andy|
      // +---+----+
      promises.push(transformedDS.collect())

      js.Promise.all(promises) onComplete {
        case Success(v) => resolve(v)
        case Failure(e) => reject(e.getMessage)
      }
    })
  }

  def runProgrammaticSchemaExample(sparkSession: SparkSession, spark: Spark): js.Promise[Unit] = {
    new js.Promise((resolve, reject) => {
      // Load a text file and convert each line to a JavaScript Object.
      val rdd = sparkSession.read().textFile(root + "/data/people.txt").rdd()
      val people = rdd map { line =>
        val parts = line.split(",")
        new Person(name = parts(0), age = parts(1).trim().toInt)
      }

      //Generate the schema
      val DataTypes = spark.sql.types.DataTypes

      val fields = js.Array[StructField]()
      fields.push(DataTypes.createStructField("name", DataTypes.StringType, nullable = true))
      fields.push(DataTypes.createStructField("age", DataTypes.IntegerType, nullable = true))
      val schema = DataTypes.createStructType(fields)

      // Convert records of the RDD (people) to Rows.
      import spark.sql.RowFactory
      val rowRDD = people.map(person => RowFactory.create(js.Array(person.name, person.age)))

      //Apply the schema to the RDD.
      val peopleDataFrame = sparkSession.createDataFrame(rowRDD, schema)

      peopleDataFrame.toJSON().collect().`then` { res =>
        console.log("peopleDataFrame.toJSON(): ", res)
      }

      // Register the DataFrame as a table.
      peopleDataFrame.registerTempTable("people") foreach { _ =>
        // SQL can be run over RDDs that have been registered as tables.
        val results = sparkSession.sql("SELECT name FROM people")

        //The results of SQL queries are DataFrames and support all the normal RDD operations.
        //The columns of a row in the result can be accessed by ordinal.
        val names = results.toRDD().map { row => "Name: " + row.getString(0) }
        names.take(10) onComplete {
          case Success(v) => resolve(v)
          case Failure(e) => reject(e.getMessage)
        }
      }
    })
  }
  
  def runInferSchemaExample(sparkSession: SparkSession, spark: Spark): js.Promise[Nothing] = {
    new js.Promise((resolve, reject) => {
      // Load a text file and convert each line to a JavaScript Object.
      val rdd = sparkSession.read().textFile(root + "/data/people.txt").rdd()
      val peopleRDD = rdd.map(line => {
        val parts = line.split(",")
        new Person(name = parts(0), age = parts(1).trim().toInt)
      })

      //Generate the schema
     import spark.sql.types.DataTypes

      val fields = js.Array[StructField]()
      fields.push(DataTypes.createStructField("name", DataTypes.StringType, nullable =  true))
      fields.push(DataTypes.createStructField("age", DataTypes.IntegerType, nullable =  true))
      val schema = DataTypes.createStructType(fields)

      import spark.sql.RowFactory
      val rowRDD = peopleRDD.map(person => RowFactory.create(js.Array(person.name, person.age)))

      val peopleDF = sparkSession.createDataFrame(rowRDD, schema)

      // Register the DataFrame as a temporary view
      peopleDF.createOrReplaceTempView("people").`then`(_ => {

        // SQL statements can be run by using the sql methods provided by spark
        val teenagersDF = sparkSession.sql("SELECT name FROM people WHERE age BETWEEN 13 AND 19")

        // The columns of a row in the result can be accessed by field index
        val stringEncoder = spark.sql.Encoders.STRING()
        val teenagerNamesByIndexDF = teenagersDF.map(row => "Name: " + row.getString(0), stringEncoder)

        val promises = js.Array[js.Promise[_]]()
        promises.push(teenagerNamesByIndexDF.take(5))

        // or by field name
        val teenagerNamesByFieldDF = teenagersDF.map(row => "Name: " + row.getAs("name"), stringEncoder)
        promises.push(teenagerNamesByFieldDF.take(5))

        js.Promise.all(promises) onComplete {
          case Success(v) => resolve(v)
          case Failure(e) => reject(e.getMessage)
        }
      })
    })
  }
  
  if (global.SC) {
    // we are being run as part of a test
    module.exports = run
  } else {
    val spark = Spark()
    val sparkSession = spark.sql.SparkSession
      .builder()
      .appName("Spark SQL Example")
      .getOrCreate()

    val promises = js.Array[js.Promise[_]]()
    promises.push(runBasicDataFrameExample(sparkSession, spark))
    promises.push(runDatasetCreationExample(sparkSession, spark))
    promises.push(runInferSchemaExample(sparkSession, spark))
    promises.push(runProgrammaticSchemaExample(sparkSession, spark))

    js.Promise.all(promises) onComplete {
      case Success(results) =>

        def printRows(rows: js.Array[Row]) = {
          var s = "\n"
          if (rows(0) != null && rows(0)._schema != null) {
            val fields = rows(0)._schema.fields
            for (i <- fields.indices) s += fields(i).name + "   "
            s += "\n"
            for (i <- fields.indices) s += "----------------------------".substring(0, fields(i).name().length) + "   "
            s += "\n"
          }

          for (i <- rows.indices) {
            s = s + rows(i).mkString("  ") + "\n"
          }
          s
        }

      console.log("""Basic Dataframe Results for 'df.take' : """, printRows(results(0)(0)))
      console.log("""Basic Dataframe Results for 'df.select("name").take" : """, printRows(results(0)(1)))
      console.log("""Basic Dataframe Results for 'df.select(col("name"), col("age").plus(1)).take" : """, printRows(results(0)(2)))
      console.log("""Basic Dataframe Results for 'df.filter(col("age").gt(21)).take" : """, printRows(results(0)[3]))
      console.log("""Basic Dataframe Results for "SELECT * FROM people" : """, printRows(results(0)[4]))

      console.log("""Dataset Creation Example Results : """, printRows(results(1)(0)))
      console.log("""Dataset Creation Example Results : """, results(1)(1))
      console.log("""Infer Schema Results : """, results(2))
      console.log("""Programmatic Schema Results : """, results(3))
      stop()
      case Failure(e) => stop(e)
    }
  }

  class Person(val name: String, val age: Int) extends js.Object

}
