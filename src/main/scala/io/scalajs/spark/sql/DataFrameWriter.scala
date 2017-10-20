package io.scalajs.spark.sql

import io.scalajs.spark.SaveMode

import scala.scalajs.js

@js.native
trait DataFrameWriter extends js.Object {

  def csv(path: String): this.type = js.native

  def mode(mode: SaveMode): this.type = js.native

  def parquet(path: String): this.type = js.native

  def partitionBy(columns: String): this.type = js.native

}
