package io.scalajs.spark.sql

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Represents one row of output from a relational operator. Allows both generic access by ordinal, which will incur
  * boxing overhead for primitives, as well as native primitive access. It is invalid to use the native primitive
  * interface to retrieve a value that is null, instead a user must check isNullAt before attempting to retrieve a
  * value that might be null. To create a new Row, use RowFactory.create()
  */
@JSGlobal
@js.native
class Row() extends js.Object {

  /**
    * Returns the value at position index.
    * @param index the index
    * @return the value
    */
  def apply(index: Int): js.Any = js.native

  /**
    * Make a copy of the current Row object
    * @return a new [[Row]]
    */
  def copy(): this.type = js.native

  /**
    * Returns the index of a given field name.
    * @param name the name of the field
    * @return the index
    */
  def fieldIndex(name: String): Int = js.native

  /**
    * Returns the value at position index.
    * @param index the index
    * @return the value
    */
  def get(index: Int): js.Any = js.native

  /**
    * Returns the value at position index as a primitive boolean.
    * @param index the index
    * @return the boolean value
    */
  def getBoolean(index: Int): Boolean = js.native

  /**
    * Returns the value at position index of type as Date.
    * @param index the index
    * @return the [[js.Date date value]]
    */
  def getDate(index: Int): js.Date = js.native

  /**
    * Returns the value at position index of type as double.
    * @param index the index
    * @return the double value
    */
  def getDouble(index: Int): Double = js.native

  /**
    * Returns the value at position index of type as float.
    * @param index the index
    * @return the float value
    */
  def getFloat(index: Int): Float = js.native

  /**
    * Returns the value at position index of type as integer.
    * @param index the index
    * @return the integer value
    */
  def getInt(index: Int): Int = js.native

  /**
    * Returns the value at position index of type as String.
    * @param index the index
    * @return the String value
    */
  def getString(index: Int): String = js.native

  /**
    * Returns the value at position index of struct type as a Row object.
    * @param index the index
    * @return the [[Row Row value]]
    */
  def getStruct(index: Int): Row = js.native

  /**
    * Returns the value at position index of date type as Date.
    * @param index the index
    * @return the [[js.Date value]]
    */
  def getTimestamp(index: Int): js.Date = js.native

  /**
    * Checks whether the value at position index is null.
    * @param index the index
    * @return true, if the value at position index is null.
    */
  def isNullAt(index: Int): Boolean = js.native

  /**
    * Number of elements in the Row.
    * @return a promise of the length
    */
  def length(): js.Promise[Int] = js.native

  /**
    * Displays all elements of this traversable or iterator in a string using start, end, and separator strings.
    * @param separator
    * @param start
    * @param end
    * @return
    */
  def mkString(separator: String = js.native, start: Int = js.native, end: Int = js.native): js.Promise[String] = js.native

  /**
    * Schema for the row.
    * @return
    */
  def schema(): js.Promise[String] = js.native

  /**
    * Number of elements in the Row.
    * @return the number of elements
    */
  def size(): Int = js.native

}
