package io.scalajs.npm.eclairjs.sql

import SaveMode.SaveMode

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Interface used to write a DataFrame to external storage systems (e.g. file systems, key-value stores, etc).
  * Use write to access this.
  * @see https://eclairjs.github.io/eclairjs/client/docs/jsdoc/module-eclairjs_sql.DataFrameWriter.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class DataFrameWriter() extends js.Object {

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

  /**
    * Saves the content of the DataFrame in JSON format at the specified path. This is equivalent to:
    * @param path the output path
    * @return a completion promise
    */
  def json(path: String): js.Promise[Unit] = js.native

  /**
    * Specifies the behavior when data or table already exists. Options include: - `overwrite`: overwrite the existing
    * data. - `append`: append the data. - `ignore`: ignore the operation (i.e. no-op). - `error`: default option,
    * throw an exception at runtime.
    * @param saveMode the given [[SaveMode save mode]]
    * @return the [[DataFrameWriter]]
    */
  def mode(saveMode: SaveMode): this.type = js.native

  /**
    * Saves the content of the DataFrame in ORC format at the specified path. This is equivalent to:
    * @param path the output path
    * @return a completion promise
    */
  def orc(path: String): js.Promise[Unit] = js.native

  /**
    * Saves the content of the DataFrame in Parquet format at the specified path. This is equivalent to:
    * @param path the output path
    * @return a completion promise
    */
  def parquet(path: String): js.Promise[Unit] = js.native

  /**
    * Partitions the output by the given columns on the file system. If specified, the output is laid out on the file
    * system similar to Hive's partitioning scheme. This is only applicable for Parquet at the moment
    * @param columns the partition columns
    * @return the [[DataFrameWriter]]
    */
  def partitionBy(columns: String*): this.type = js.native

  /**
    * Saves the content of the DataFrame as the specified table.
    * @param path the optional output path
    * @return a completion promise
    */
  def save(path: String = js.native): js.Promise[Unit] = js.native

  /**
    * Saves the content of the DataFrame as the specified table. In the case the table already exists, behavior of
    * this function depends on the save mode, specified by the `mode` function (default to throwing an exception).
    * When `mode` is `Overwrite`, the schema of the DataFrame does not need to be the same as that of the existing
    * table. When `mode` is `Append`, the schema of the DataFrame need to be the same as that of the existing table,
    * and format or options will be ignored. When the DataFrame is created from a non-partitioned HadoopFsRelation
    * with a single input path, and the data source provider can be mapped to an existing Hive builtin SerDe
    * (i.e. ORC and Parquet), the table is persisted in a Hive compatible format, which means other systems like
    * Hive will be able to read this table. Otherwise, the table is persisted in a Spark SQL specific format.
    * @param tableName the given table name
    * @return a completion promise
    * @see [[SaveMode]]
    */
  def saveAsTable(tableName: String): js.Promise[Unit] = js.native

}

/**
  * DataFrameWriter Companion
  * @author lawrence.daniels@gmail.com
  */
object DataFrameWriter {

  final implicit class DataFrameWriterEnrichment(val writer: DataFrameWriter) extends AnyVal {

    @inline
    def csv(path: String): js.Promise[Unit] = writer.save(path)

  }

}
