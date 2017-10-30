package io.scalajs.npm.eclairjs.sql

object SaveMode {
  type SaveMode = String

  val Append: SaveMode = "Append"
  val Overwrite: SaveMode = "Overwrite"

}
