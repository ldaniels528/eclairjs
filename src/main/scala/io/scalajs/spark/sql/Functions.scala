package io.scalajs.spark.sql

import scala.scalajs.js
import scala.scalajs.js.|

/**
  * Spark SQL functions.
  * @see https://eclairjs.github.io/eclairjs/client/docs/jsdoc/module-eclairjs_sql.functions.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Functions extends js.Object {

  /**
    * Computes the absolute value.
    * @param column the given column
    * @return a column representing the function
    */
  def abs(column: Column): Column = js.native

  /**
    * Computes the cosine inverse of the given value; the returned angle is in the range 0.0 through pi.
    * @param column the given column
    * @return a column representing the function
    */
  def acos(column: Column): Column = js.native

  /**
    * Returns the date that is numMonths after startDate.
    * @param startDate the start date
    * @param numMonths the number of months
    * @return a column representing the function
    */
  def add_months(startDate: Column, numMonths: Int): Column = js.native

  /**
    * Aggregate function: returns the approximate number of distinct items in a group.
    * @param column object or column name as a string
    * @param rsd    the RSD value
    * @return a column representing the function
    */
  def approxCountDistinct(column: Column, rsd: Double = js.native): Column = js.native

  /**
    * Creates a new array column. The input columns must all have the same data type.
    * @param columnExpr the given column/expression
    * @return a column representing the function
    */
  def array(columnExpr: (String | Column)*): Column = js.native

  /**
    * Returns true if the array contain the value
    * @param column the given column
    * @param value  the value to check for
    * @return a column representing the function
    */
  def array_contains(column: Column, value: js.Any): Column = js.native

  /**
    * Returns a sort expression based on ascending order of the column.
    * @param columnName the given column name
    * @return a column representing the function
    */
  def asc(columnName: String): Column = js.native

  /**
    * Computes the numeric value of the first character of the string column, and returns the result as a int column.
    * @param column the given column
    * @return a column representing the function
    */
  def ascii(column: Column): Column = js.native

  /**
    * Computes the sine inverse of the given value; the returned angle is in the range -pi/2 through pi/2.
    * @param column the given column
    * @return a column representing the function
    */
  def asin(column: Column): Column = js.native

  /**
    * Computes the tangent inverse of the given value.
    * @param column the given column
    * @return a column representing the function
    */
  def atan(column: Column): Column = js.native

  /**
    * Returns the angle theta from the conversion of rectangular coordinates (x, y) to polar coordinates (r, theta).
    * @param left  the left value
    * @param right the right value
    * @return a column representing the function
    */
  def atan2(left: Column | String | Double, right: Column | String | Double): Column = js.native

  /**
    * Aggregate function: returns the average of the values in a group.
    * @param column the given column
    * @return a column representing the function
    */
  def avg(column: Column): Column = js.native

  /**
    * Computes the BASE64 encoding of a binary column and returns it as a string column. This is the reverse of unbase64.
    * @param column the given column
    * @return a column representing the function
    */
  def base64(column: Column): Column = js.native

  /**
    * An expression that returns the string representation of the binary value of the given long column. For example, bin("12") returns "1100".
    * @param column the given column
    * @return a column representing the function
    */
  def bin(column: Column): Column = js.native

  /**
    * Computes bitwise NOT.
    * @param column the given column
    * @return a column representing the function
    */
  def bitwiseNOT(column: Column): Column = js.native

  /**
    * Marks a DataFrame as small enough for use in broadcast joins. The following example marks the right DataFrame for
    * broadcast hash join using `joinKey`.
    * @param df the given [[DataFrame]]
    * @return a [[DataFrame]]
    */
  def broadcast(df: DataFrame): DataFrame = js.native

  /**
    * Computes the cube-root of the given value.
    * @param column the given column
    * @return a column representing the function
    */
  def cbrt(column: Column): Column = js.native

  /**
    * Computes the ceiling of the given value.
    * @param column the given column
    * @return a column representing the function
    */
  def ceil(column: Column): Column = js.native

  /**
    * Returns the first column that is not null, or null if all inputs are null. For example, `coalesce(a, b, c) will
    * return a if a is not null, or b if a is null and b is not null, or c if both a and b are null but c is not null.
    * @param column the given column
    * @return a column representing the function
    */
  def coalesce(column: Column*): Column = js.native

  /**
    * Returns a Column based on the given column name.
    * @param name the given column name.
    * @return a [[Column]]
    */
  def col(name: String): Column = js.native

  /**
    * Returns a [[Column]] based on the given column name. Alias of [[col]].
    * @param name the given column name.
    * @return a [[Column]]
    */
  def column(name: String): Column = js.native

  /**
    * Concatenates multiple input string columns together into a single string column.
    * @param columnExpr ...columnExpr or columnName, ...columnName
    * @return a [[Column]]
    */
  def concat(columnExpr: (Column | String)*): Column = js.native

  /**
    * Concatenates multiple input string columns together into a single string column, using the given separator.
    * @param sep        the given separator.
    * @param columnExpr the  input string columns
    * @return a [[Column]]
    */
  def concat_ws(sep: String, columnExpr: (Column | String)*): Column = js.native

  /**
    * Convert a number in a string column from one base to another.
    * @param num      the given number
    * @param fromBase the initial base
    * @param toBase   the target base
    * @return a column representing the function
    */
  def conv(num: Column, fromBase: Int, toBase: Int): Column = js.native

  /**
    * Computes the cosine of the given value.
    * @param column the given column
    * @return a column representing the function
    */
  def cos(column: Column): Column = js.native

  /**
    * Computes the hyperbolic cosine of the given value.
    * @param column the given column
    * @return a column representing the function
    */
  def cosh(column: Column): Column = js.native

  /**
    * Aggregate function: returns the number of items in a group.
    * @param column the given column
    * @return a column representing the function
    */
  def count(column: Column): Column = js.native

}
