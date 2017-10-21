package io.scalajs.spark.sql

import io.scalajs.spark.SaveMode

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
@JSGlobal
class DataFrameWriter() extends js.Object {

  def csv(path: String): this.type = js.native

  /**
    * Specifies the underlying output data source. Built-in options include "parquet", "json", etc.
    * @param source the output data source format
    * @return the [[DataFrameWriter]]
    */
  def format(source: String): this.type = js.native

  /**
    * Inserts the content of the DataFrame to the specified table. It requires that the schema of the DataFrame is the
    * same as the schema of the table. Because it inserts data to an existing table, format or options will be ignored.
    * @param tableName the given table name
    * @return a completion promise
    */
  def insertInto(tableName: String): js.Promise[Unit] = js.native

  /**
    * Construct a DataFrame representing the database table accessible via JDBC URL
    * @param url                  the JDBC url
    * @param table                the JDBC table
    * @param connectionProperties the JDBC connection properties
    * @return a completion promise
    */
  def jdbc(url: String, table: String, connectionProperties: js.Dictionary[String]): js.Promise[Unit] = js.native

  def mode(mode: SaveMode): this.type = js.native

  def parquet(path: String): this.type = js.native

  def partitionBy(columns: String): this.type = js.native

}
