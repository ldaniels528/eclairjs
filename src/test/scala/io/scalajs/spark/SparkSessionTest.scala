package io.scalajs.spark

import io.scalajs.spark.sql.SparkSession
import org.scalatest.FunSpec

/**
  * Spark Session Tests
  * @author lawrence.daniels@gmail.com
  */
class SparkSessionTest extends FunSpec {

  describe("SparkSession") {

    it("should process a CSV file") {
      val spark: SparkSession = SparkSession.builder()
        .appName("Spark-Sample")
        .master("local[*]")
        .config(new SparkConf()
          .set("hive.exec.dynamic.partition", "true")
          .set("hive.exec.dynamic.partition.mode", "nonstrict")
          .set("spark.debug.maxToStringFields", "2048")
          .set("spark.sql.avro.compression.codec", "deflate")
          .set("spark.sql.avro.deflate.level", "5"))
        .enableHiveSupport()
        .getOrCreate()

      spark.read().csv("./data/in")
        .withColumnRenamed("_c0", "client")
        .withColumnRenamed("_c1", "campaign")
        .withColumnRenamed("_c2", "data_processed_dt")
        .withColumnRenamed("_c3", "account")
        .withColumnRenamed("_c4", "impressions")
        .withColumnRenamed("_c5", "clicks")
        .withColumnRenamed("_c6", "publisher_cost")
        .withColumnRenamed("_c7", "avg_cpc")
        .withColumnRenamed("_c8", "report_processed_dt")
        .write
        .mode(SaveMode.Append)
        .partitionBy("report_processed_dt")
        .csv("./data/out/claudia/")
    }

  }

}
