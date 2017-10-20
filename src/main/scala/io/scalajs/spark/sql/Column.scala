package io.scalajs.spark.sql

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSName}

/**
  * A column in a DataFrame.
  * @param name the name of the column
  */
@JSGlobal
@js.native
class Column(name: String) extends js.Object {

  /**
    * Gives the column an alias. Same as as.
    * @param alias the alias name
    * @return the new [[Column column]]
    */
  def alias(alias: String): this.type = js.native

  /**
    * Boolean AND.
    * @param other the other [[Column column]]
    * @return the new [[Column column]]
    */
  def and(other: Column): this.type = js.native

  /**
    * Gives the column an alias.
    * @param aliases  if array of strings assigns the given aliases to the results of a table generating function.
    * @param metadata not valid with string array
    */
  def as(aliases: js.Array[String], metadata: js.Object = js.native): this.type = js.native

  /**
    * Returns an ordering used in sorting.
    * @return an ordering used in sorting.
    * @example df.sort(df.col("age").asc());
    */
  def asc(): this.type = js.native

  /**
    * True if the current column is between the lower bound and upper bound, inclusive.
    * @param lowerBound the lower bound [[Column column]]
    * @param upperBound the upper bound [[Column column]]
    * @return the new [[Column column]]
    */
  def between(lowerBound: Column, upperBound: Column): this.type = js.native

  /**
    * Compute bitwise AND of this expression with another expression.
    * @param other the other [[Column column]]
    * @return the new [[Column column]]
    */
  def bitwiseAND(other: Column): this.type = js.native

  /**
    * Compute bitwise XOR of this expression with another expression.
    * @param other the other [[Column column]]
    * @return the new [[Column column]]
    */
  def bitwiseOR(other: Column): this.type = js.native

  /**
    * Compute bitwise XOR of this expression with another expression.
    * @param other the other [[Column column]]
    * @return the new [[Column column]]
    */
  def bitwiseXOR(other: Column): this.type = js.native

  /**
    * Casts the column to a different data type.
    * @param to If string supported types are: `string`, `boolean`, `int`, `float`, `double`, `date`, `timestamp`.
    * @return the new [[Column column]]
    */
  def cast(to: String): this.type = js.native

  /**
    * Contains the other element.
    * @param other the other [[Column column]]
    * @return the new [[Column column]]
    */
  def contains(other: Column): this.type = js.native

  /**
    * Returns an ordering used in sorting.
    * @return an ordering used in sorting.
    * @example df.sort(df.col("age").desc());
    */
  def desc(): this.type = js.native

  /**
    * Division this expression by another expression.
    * @param other the other [[Column column]]
    * @return the new [[Column column]]
    */
  def divide(other: Column): this.type = js.native

  /**
    * Equality test that is safe for null values.
    * @param other the other [[Column column]]
    * @return the new [[Column column]]
    */
  def eqNullSafe(other: Column): this.type = js.native

  /**
    * Equality test
    * @param that
    * @return
    */
  def equals(that: Column): this.type = js.native

  /**
    * Prints the expression to the console for debugging purpose.
    * @return A Promise that resolves to nothing.
    */
  def explain(): js.Promise[Unit] = js.native

  /**
    * Greater than or equal to an expression.
    * @param other the other [[Column column]]
    * @return the new [[Column column]]
    */
  def geq(other: Column): this.type = js.native

  /**
    * An expression that gets a field by name in a StructType.
    * @param fieldName the field name
    * @return the [[Column column]]
    */
  def getField(fieldName: String): Column = js.native

  /**
    * An expression that gets an item at position `ordinal` out of an array, or gets a value by key `key` in a MapType.
    * @param key the given key
    * @return the [[Column column]]
    */
  def getItem(key: Column): this.type = js.native

  /**
    * Greater than.
    * @param other the other [[Column column]]
    * @return the [[Column result]]
    */
  def gt(other: Column): this.type = js.native

  /**
    * Returns a Promise that resolves to the hashcode.
    * @return A Promise that resolves to the hashcode.
    */
  @JSName("hashCode")
  def hashCodeJS(): js.Promise[Int] = js.native

  /**
    * A boolean expression that is evaluated to true if the value of this expression is contained by the evaluated values of the arguments.
    * @param list the array of inclusive values
    * @return the [[Column column]]
    */
  def in[T <: js.Any](list: js.Array[T]): this.type = js.native

  /**
    * A boolean expression that is evaluated to true if the value of this expression is contained by the evaluated values of the arguments.
    * @param list the array of inclusive values
    * @return the [[Column column]]
    */
  def isin[T <: js.Any](list: js.Array[T]): this.type = js.native

  /**
    * True if the current expression is NaN.
    * @return the [[Column column]]
    */
  def isNaN(): this.type = js.native

  /**
    * True if the current expression is NOT null.
    * @return the [[Column column]]
    */
  def isNotNull(): this.type = js.native

  /**
    * True if the current expression is null.
    * @return the [[Column column]]
    */
  def isNull(): this.type = js.native

  /**
    * Less than or equal to.
    * @param other the other [[Column column]]
    * @return the [[Column column]]
    */
  def leq(other: Column): this.type = js.native

  /**
    * SQL like expression.
    * @param literal a string literal
    * @return the [[Column column]]
    */
  def like(literal: String): this.type = js.native

  /**
    * Less than.
    * @param other the other [[Column column]]
    * @return the [[Column column]]
    */
  def lt(other: Column): this.type = js.native

  /**
    * Subtraction. Subtract the other expression from this expression.
    * @param other the other [[Column column]]
    * @return the [[Column column]]
    */
  def minus(other: Column): this.type = js.native

  /**
    * Modulo (a.k.a. remainder) expression.
    * @param other the other [[Column column]]
    * @return the [[Column column]]
    */
  def mod(other: Column): this.type = js.native

  /**
    * Multiplication of this expression and another expression.
    * @param other the other [[Column column]]
    * @return the [[Column column]]
    */
  def multiply(other: Column): this.type = js.native

  /**
    * Inequality test.
    * @param other the other [[Column column]]
    * @return the [[Column column]]
    */
  def notEqual(other: Column): this.type = js.native

  /**
    * Boolean OR.
    * @param other the other [[Column column]]
    * @return the [[Column column]]
    */
  def or(other: Column): this.type = js.native

  /**
    * Evaluates a list of conditions and returns one of multiple possible result expressions.
    * If otherwise is not defined at the end, null is returned for unmatched conditions.
    * @param value the default value
    * @return the new [[Column column]]
    */
  def otherwise(value: js.Any): this.type = js.native

  /**
    * Sum of this expression and another expression.
    * @param other the other [[Column column]]
    * @return the new [[Column column]]
    */
  def plus(other: Column): this.type = js.native

  /**
    * Evaluates a list of conditions and returns one of multiple possible result expressions.
    * If otherwise is not defined at the end, null is returned for unmatched conditions.
    * @param column the [[Column column]]
    * @return the new [[Column column]]
    */
  def when(column: Column, value: js.Any): this.type = js.native

}

/**
  * Column Companion
  * @author lawrence.daniels@gmail.com
  */
object Column {

  final implicit class ColumnEnrichment(val column: Column) extends AnyVal {

    /**
      * Equality test that is safe for null values.
      * @param other the other [[Column column]]
      * @return the new [[Column column]]
      */
    @inline
    def ===(other: Column): Column = column.eqNullSafe(other)

    /**
      * Greater than or equal to an expression.
      * @param other the other [[Column column]]
      * @return the new [[Column column]]
      */
    @inline
    def >=(other: Column): Column = column.geq(other)

    /**
      * Greater than.
      * @param other the other [[Column column]]
      * @return the [[Column result]]
      */
    @inline
    def >(other: Column): Column = column.gt(other)

    /**
      * Less than or equal to.
      * @param other the other [[Column column]]
      * @return the [[Column column]]
      */
    @inline
    def <=(other: Column): Column = column.leq(other)

    /**
      * Less than.
      * @param other the other [[Column column]]
      * @return the [[Column column]]
      */
    @inline
    def <(other: Column): Column = column.lt(other)

    /**
      * Division this expression by another expression.
      * @param other the other [[Column column]]
      * @return the new [[Column column]]
      */
    @inline
    def /(other: Column): Column = column.divide(other)

    /**
      * Subtraction. Subtract the other expression from this expression.
      * @param other the other [[Column column]]
      * @return the [[Column column]]
      */
    @inline
    def -(other: Column): Column = column.minus(other)

    /**
      * Modulo (a.k.a. remainder) expression.
      * @param other the other [[Column column]]
      * @return the [[Column column]]
      */
    @inline
    def %(other: Column): Column = column.mod(other)

    /**
      * Multiplication of this expression and another expression.
      * @param other the other [[Column column]]
      * @return the [[Column column]]
      */
    @inline
    def *(other: Column): Column = column.multiply(other)

    /**
      * Inequality test.
      * @param other the other [[Column column]]
      * @return the [[Column column]]
      */
    @inline
    def =!=(other: Column): Column = column.notEqual(other)

    /**
      * Boolean OR.
      * @param other the other [[Column column]]
      * @return the [[Column column]]
      */
    @inline
    def ||(other: Column): Column = column.or(other)

    /**
      * Sum of this expression and another expression.
      * @param other the other [[Column column]]
      * @return the new [[Column column]]
      */
    @inline
    def +(other: Column): Column = column.plus(other)

  }

}