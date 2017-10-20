package io.scalajs.spark.sql

import io.scalajs.spark.DataSet
import io.scalajs.spark.sql.types.StructType

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Interface used to load a DataFrame from external storage systems (e.g. file systems, key-value stores, etc).
  * Use SQLContext.read to access this.
  * @see https://eclairjs.github.io/eclairjs/client/docs/jsdoc/module-eclairjs_sql.DataFrameReader.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class DataFrameReader() extends js.Object {

  def csv(path: String): DataFrame = js.native

  /**
    * Specifies the input data source format.
    * @param source the input data source format
    * @return the [[DataFrameReader]]
    */
  def format(source: String): this.type = js.native

  /**
    * Construct a DataFrame representing the database table accessible via JDBC URL
    * @param url                  the JDBC url
    * @param table                the JDBC table
    * @param connectionProperties the JDBC connection properties
    * @return a [[DataFrame]]
    */
  def jdbc(url: String, table: String, connectionProperties: js.Dictionary[String]): DataFrame = js.native

  /**
    * Loads input in as a DataFrame
    * @param path Loads data sources that require a path (e.g. data backed by a local or distributed file system).
    *             If not specified loads data sources that don't require a path (e.g. external key-value stores).
    * @return a [[DataFrame]]
    */
  def load(path: String = js.native): DataFrame = js.native

  /**
    * Adds an input option for the underlying data source.
    * @param key   the option's key
    * @param value the option's value
    * @return the [[DataFrameReader]]
    */
  def option(key: String, value: String): this.type = js.native

  /**
    * Adds input options for the underlying data source.
    * @param options the options map
    * @return the [[DataFrameReader]]
    */
  def options(options: js.Dictionary[String]): this.type = js.native

  /**
    * Loads an ORC file and returns the result as a DataFrame.
    * @param path the input path
    * @return the [[DataFrameReader]]
    */
  def orc(path: String): DataFrame = js.native

  /**
    * Loads a Parquet file, returning the result as a DataFrame. This function returns an empty DataFrame if no paths are passed in.
    * @param path the input path
    * @return the [[DataFrameReader]]
    */
  def parquet(path: String): DataFrame = js.native

  /**
    * Specifies the input schema. Some data sources (e.g. JSON) can infer the input schema automatically from data.
    * By specifying the schema here, the underlying data source can skip the schema inference step, and thus speed up
    * data loading.
    * @param schema the given [[StructType schema]]
    * @return the [[DataFrameReader]]
    */
  def schema(schema: StructType): this.type = js.native

  /**
    * Returns the specified table as a DataFrame.
    * @param tableName the specified table
    * @return a [[DataFrame]]
    */
  def table(tableName: String): DataFrame = js.native

  /**
    * Loads text files and returns a Dataset of String. See the documentation on the other overloaded `textFile()` method for more details.
    * @param path the input path
    * @return a [[DataFrame]]
    */
  def textFile(path: String): DataSet = js.native

}