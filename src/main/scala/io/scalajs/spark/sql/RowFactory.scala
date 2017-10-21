package io.scalajs.spark.sql

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * A factory class used to construct Row objects.
  */
@js.native
@JSGlobal
class RowFactory extends js.Object {

}

/**
  * RowFactory Singleton
  */
@js.native
@JSGlobal
object RowFactory extends js.Object {

  /**
    * Create a Row from the given arguments. Position i in the argument list becomes position i in the created Row object.
    * @param values the given values
    * @return a [[Row]]
    */
  def create(values: js.Array[js.Any]): Row = js.native

}
