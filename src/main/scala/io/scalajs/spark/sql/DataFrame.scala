package io.scalajs.spark.sql

import scala.scalajs.js

/**
  * A distributed collection of data organized into named columns. A DataFrame is equivalent to a relational table in Spark SQL.
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait DataFrame extends DataSet[Row] {

  /**
    *
    * @param name
    * @return
    */
  def and(name: String): Column = js.native

  /**
    *
    * @param column
    * @return
    */
  def apply(column: String): Column = js.native

  /**
    *
    * @param name
    * @return
    * @example df.select(df.col("colA").alias("colB"))
    */
  def col(name: String): Column = js.native

  /**
    *
    * @param cols
    * @return
    */
  def select(cols: Column*): this.type = js.native

  /**
    *
    * @param col
    * @return
    */
  def sort(col: Column): this.type = js.native

  /**
    *
    * @param oldName
    * @param newName
    * @return
    */
  def withColumnRenamed(oldName: String, newName: String): this.type = js.native

  /**
    *
    * @return
    */
  def write: DataFrameWriter = js.native

}
