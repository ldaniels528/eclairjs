package io.scalajs.spark.sql

object SaveMode {
  type SaveMode = String

  val Append: SaveMode = "Append"
  val Overwrite: SaveMode = "Overwrite"

}
