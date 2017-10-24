package io.scalajs.spark.sql

import io.scalajs.spark.RDD

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal
class DataSet[T] extends js.Object {

  def collect(): js.Promise[js.Array[T]] = js.native

  def map[U](f: js.Function1[T, U], bindArgs: js.Any = js.native): DataSet[U] = js.native

  def rdd(): RDD[T] = js.native

  def registerTempTable(table: String): js.Promise[Unit]  = js.native

  def take(count: Int): js.Promise[js.Array[T]] = js.native

  def toJSON(): DataSet[String] = js.native

}
