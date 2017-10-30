package io.scalajs.npm.eclairjs.sql

import io.scalajs.npm.eclairjs.RDD

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * Data Set
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class DataSet[T] extends RDD[T] {

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
    * @param table
    * @return
    */
  def createOrReplaceTempView(table: String): js.Promise[Unit] = js.native

  def filter(column: Column): this.type = js.native

  /**
    *
    * @param v
    * @param bindArgs
    * @tparam U
    * @return
    */
  override def flatMap[U](v: T => js.Array[U], bindArgs: js.Array[U] = js.native): DataSet[U] = js.native

  def groupBy(column: Column | String): this.type = js.native

  /**
    *
    * @param v
    * @param bindArgs
    * @tparam U
    * @return
    */
  override def map[U](v: T => U, bindArgs: js.Array[U] = js.native): DataSet[U] = js.native

  def rdd(): DataSet[T] = js.native

  def registerTempTable(table: String): js.Promise[Unit] = js.native

  /**
    *
    * @param cols
    * @return
    */
  def select(cols: (Column | String)*): this.type = js.native

  /**
    *
    * @param col
    * @return
    */
  def sort(col: Column): this.type = js.native

  def toJSON(): DataSet[String] = js.native

  def toRDD(): RDD[T] = js.native

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
  def write(): DataFrameWriter = js.native

}
