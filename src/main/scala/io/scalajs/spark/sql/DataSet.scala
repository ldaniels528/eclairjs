package io.scalajs.spark.sql

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal
class DataSet[T] extends js.Object {

  def collect(): js.Promise[js.Array[T]] = js.native

  def take(count: Int): js.Promise[js.Array[T]] = js.native

}
