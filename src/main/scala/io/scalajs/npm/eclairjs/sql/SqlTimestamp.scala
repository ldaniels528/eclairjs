package io.scalajs.npm.eclairjs.sql

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSName}
import scala.scalajs.js.|

/**
  * A thin wrapper around Date that allows the JDBC API to identify this as an SQL TIMESTAMP value. It adds the ability
  * to hold the SQL TIMESTAMP fractional seconds value, by allowing the specification of fractional seconds to a
  * precision of nanoseconds. A Timestamp also provides formatting and parsing operations to support the JDBC escape
  * syntax for timestamp values.
  * @see https://eclairjs.github.io/eclairjs/client/docs/jsdoc/module-eclairjs_sql.SqlTimestamp.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class SqlTimestamp(number: Double | String | js.Date) extends js.Object {

  /**
    * Tests if this date is after the specified Timestamp object.
    * @param when the specified Timestamp object
    * @return true if this date is after the specified Timestamp object
    */
  def after(when: SqlTimestamp): Boolean = js.native

  /**
    * Tests if this date is before the specified Timestamp object.
    * @param when the specified Timestamp object
    * @return true if this date is before the specified Timestamp object.
    */
  def before(when: SqlTimestamp): Boolean = js.native

  /**
    * Return a copy of this object.
    * @return a copy of this object.
    */
  @JSName("clone")
  def cloneJS(): this.type = js.native

  /**
    * Compares two Dates for ordering
    * @param anotherDate the specified Timestamp object
    * @return a result indicating whether the value was greater, lesser or equal
    */
  def compareTo(anotherDate: SqlTimestamp): Int = js.native

  /**
    * Compares two dates for equality.
    * @param when the specified Timestamp object
    * @return true, if the two dates are equal
    */
  def equals(when: SqlTimestamp): Boolean = js.native

  /**
    * Gets this Timestamp object's nanos value.
    * @return the nanoseconds
    */
  def getNanos(): Int = js.native

  /**
    * Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Timestamp object
    * @return the milliseconds
    */
  def getTime(): Int = js.native

  /**
    * Sets this Timestamp object's nanos field to the given value.
    * @param nanos the nanoseconds
    */
  def setNanos(nanos: Int): Unit = js.native

  /**
    * Sets an existing Date object using the given milliseconds time value.
    * @param milliseconds the given milliseconds
    */
  def setTime(milliseconds: Double): Unit = js.native

  /**
    * Formats a date in the date escape format yyyy-mm-dd.
    * @return a date string
    */
  def toJSON(): String = js.native

}
