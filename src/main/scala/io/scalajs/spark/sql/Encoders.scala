package io.scalajs.spark.sql

import scala.scalajs.js

@js.native
trait Encoders extends js.Object {

  def INT(): Encoder = js.native

  def json(value: js.Any): Encoder = js.native



}
