package io.scalajs.spark.sql

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSName}
import scala.scalajs.js.|

/**
  * A thin wrapper around a millisecond value that allows JDBC to identify this as an SQL DATE value. A milliseconds
  * value represents the number of milliseconds that have passed since January 1, 1970 00:00:00.000 GMT. To conform
  * with the definition of SQL DATE, the millisecond values wrapped by a java.sql.Date instance must be 'normalized'
  * by setting the hours, minutes, seconds, and milliseconds to zero in the particular time zone with which the
  * instance is associated.
  * @see https://eclairjs.github.io/eclairjs/client/docs/jsdoc/module-eclairjs_sql.SqlDate.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class SqlDate(number: Double | String | js.Date) extends js.Object {

  /**
    * Tests if this date is after the specified date.
    * @param when the specified date
    * @return true if this date is after the specified date
    */
  def after(when: SqlDate): Boolean = js.native

  /**
    * Tests if this date is before the specified date.
    * @param when the specified date
    * @return true if this date is before the specified date.
    */
  def before(when: SqlDate): Boolean = js.native

  /**
    * Return a copy of this object.
    * @return a copy of this object.
    */
  @JSName("clone")
  def cloneJS(): this.type = js.native

  /**
    * Compares two Dates for ordering
    * @param anotherDate the specified date
    * @return a result indicating whether the value was greater, lesser or equal
    */
  def compareTo(anotherDate: SqlDate): Int = js.native

  /**
    * Compares two dates for equality.
    * @param when the specified date
    * @return true, if the two dates are equal
    */
  def equals(when: SqlDate): Boolean = js.native

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
