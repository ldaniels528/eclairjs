package io.scalajs.npm.eclairjs.sql

import scala.scalajs.js

@js.native
trait SQL extends js.Object {

  val functions: Functions = js.native

  val Encoders: Encoders = js.native

  val RowFactory: RowFactory = js.native

  val SparkSession: SparkSession = js.native

  val types: Types = js.native

}
