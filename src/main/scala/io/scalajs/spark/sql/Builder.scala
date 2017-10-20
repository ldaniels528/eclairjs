package io.scalajs.spark.sql

import io.scalajs.spark.SparkConf

import scala.scalajs.js

/**
  * Spark Session Builder
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Builder extends js.Object {

  def appName(name: String): this.type = js.native

  def config(conf: SparkConf): this.type = js.native

  def getOrCreate(): SparkSession = js.native

  def master(master: String): this.type = js.native

  def enableHiveSupport(): this.type = js.native

}
