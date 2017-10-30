package io.scalajs.npm.eclairjs.sql

import io.scalajs.npm.eclairjs.SparkContext
import io.scalajs.npm.eclairjs.sql.types.StructType

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * The entry point for working with structured data (rows and columns) in Spark. Allows the creation of DataFrame
  * objects as well as the execution of SQL queries.
  * @see https://eclairjs.github.io/eclairjs/client/docs/jsdoc/module-eclairjs_sql.SQLContext.html
  * @author lawrence.daniels@gmail.com
  */
@JSGlobal
@js.native
class SQLContext(sparkContext: SparkContext) extends js.Object {

  /**
    * Creates a DataFrame from RDD of Rows using the schema
    * @param rowRDD the given rows of RDDs
    * @param schema the given schema
    * @return a [[DataFrame]]
    */
  def createDataFrame(rowRDD: js.Array[Row], schema: StructType): DataFrame = js.native

  /**
    * Creates a DataFrame from RDD of JSON
    * @param schema the given schema
    * @return a [[DataFrame]]
    */
  def createDataFrameFromJson(schema: js.Any): DataFrame = js.native

  /**
    * Returns DataFrameReader
    * @return a [[DataFrameReader]]
    */
  def read(): DataFrameReader = js.native

  /**
    * Returns DataFrame
    * @param sqlString the given SQL string
    * @return a [[DataFrame]]
    */
  def sql(sqlString: String): DataFrame = js.native

  /**
    * Returns the specified table as a DataFrame.
    * @param tableName the given table name
    * @return a [[DataFrame]]
    */
  def table(tableName: String): DataFrame = js.native

}
