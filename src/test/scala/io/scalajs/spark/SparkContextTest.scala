package io.scalajs.spark

import io.scalajs.nodejs.console
import io.scalajs.spark.Implicits._
import io.scalajs.util.PromiseHelper.Implicits._
import org.scalatest.FunSpec

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.util.{Failure, Success}

/**
  * Spark Tests
  * @author lawrence.daniels@gmail.com
  */
class SparkContextTest extends FunSpec {

  describe("SparkContext") {
    implicit val spark = Spark()

    it("should run the 'Simple Spark Program' example") {
      val sc = spark.SparkContext("local[*]", "Simple Spark Program")

      val rdd = sc.parallelize(js.Array(1.10, 2.2, 3.3, 4.4))

      rdd.collect() onComplete {
        case Success(results) =>
          console.log("results: ", results)
          sc.stop()
        case Failure(e) =>
          console.error(e.getMessage)
          sc.stop()
      }
    }

    it("should run the 'Simple Word Count' example") {
      val sc = spark.SparkContext("local[*]", "Simple Word Count")

      val textFile = sc.textFile("foo.txt")

      val words = textFile.flatMap(_.split(" ").toJSArray)

      val wordsWithCount = words.mapToPair(word => word -> 1)

      val reducedWordsWithCount = wordsWithCount.reduceByKey((value1, value2) => value1 + value2)

      reducedWordsWithCount.collect() onComplete {
        case Success(results) =>
          console.log("Word Count:", results)
          sc.stop()
        case Failure(e) =>
          console.error(e.getMessage)
          sc.stop()
      }
    }

  }

}
