package io.scalajs.spark.sql

import io.scalajs.spark.RDD
import io.scalajs.spark.sql.types.StructType

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * The entry point to programming Spark with the Dataset and DataFrame API. In environments that this has been
  * created upfront (e.g. REPL, notebooks), use the builder to get an existing session.
  * @see https://eclairjs.github.io/eclairjs/client/docs/jsdoc/module-eclairjs_sql.SparkSession.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class SparkSession(appName: String, master: String) extends js.Object {

  /**
    * Convert a [[BaseRelation]] created for external data sources into a DataFrame.
    * @param baseRelation
    * @return
    */
  def baseRelationToDataFrame(baseRelation: Double): BaseRelation = js.native

  /**
    * Creates a Dataset from RDD of Rows using the schema
    * @param rdd
    * @param schema
    * @return
    */
  def createDataFrame[T <: Row](rdd: RDD[T], schema: StructType): DataSet[T] = js.native

  /**
    * Creates a Dataset from an  Array of Rows using the schema
    * @param values
    * @param schema
    * @return
    */
  def createDataFrame[T <: js.Any](values: js.Array[T], schema: StructType): DataSet[T] = js.native

  /**
    * Creates a Dataset from RDD of JSON
    * @param data    the RDD of JSON
    * @param encoder object with keys corresponding to JSON field names (or getter functions),
    *                and values indicating Datatype
    * @return a [[DataSet]]
    */
  def createDataset[T](data: js.Array[T], encoder: Encoder): DataSet[T] = js.native

  /**
    * Creates a Dataset from RDD of JSON
    * @param schema object with keys corresponding to JSON field names (or getter functions), and values indicating Datatype
    * @return a [[DataSet]]
    */
  def createDatasetFromJson(schema: StructType | js.Any, encoder: Encoder = js.native): DataSet[String] = js.native

  /**
    * Creates a new Dataset of type T containing zero elements.
    * @return a [[DataSet]]
    */
  def emptyDataset[T](): DataSet[T] = js.native

  /**
    * Start a new session with isolated SQL configurations, temporary tables, registered functions are isolated,
    * but sharing the underlying SparkContext and cached data. Note: Other than the SparkContext, all shared state
    * is initialized lazily. This method will force the initialization of the shared state to ensure that parent
    * and child sessions are set up with the same shared state. If the underlying catalog implementation is Hive,
    * this will initialize the metastore, which may take some time.
    * @return a new [[SparkSession]]
    */
  def newSession(): SparkSession = js.native

  /**
    * Returns a DataFrameReader that can be used to read non-streaming data in as a DataFrame.
    * @return a [[DataFrameReader]]
    */
  def read(): DataFrameReader = js.native

  /**
    * Executes a SQL query using Spark, returning the result as a DataFrame. The dialect that is used for SQL
    * parsing can be configured with 'spark.sql.dialect'.
    * @param sqlText the SQL text
    * @return a [[DataFrame]]
    */
  def sql(sqlText: String): DataFrame = js.native

  /**
    * Stop the underlying SparkContext.
    * @return a completion promise
    */
  def stop(): js.Promise[Unit] = js.native

}

/**
  * Spark Session Companion
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
object SparkSession extends js.Object {

  type Builder = io.scalajs.spark.sql.Builder

  /**
    * Creates a [[SparkSession.Builder]] for constructing a SparkSession.
    * @return a [[SparkSession.Builder]]
    */
  def builder(): Builder = js.native

  /**
    * Clears the active SparkSession for current thread. Subsequent calls to getOrCreate will return the first
    * created context instead of a thread-local override.
    * @return a completion promise
    */
  def clearActiveSession(): js.Promise[Unit] = js.native

  /**
    * Clears the default SparkSession that is returned by the builder.
    * @return a completion promise
    */
  def clearDefaultSession(): js.Promise[Unit] = js.native

  /**
    * Changes the SparkSession that will be returned in this thread and its children when SparkSession.getOrCreate()
    * is called. This can be used to ensure that a given thread receives a SparkSession with an isolated session,
    * instead of the global (first created) context.
    * @param session the given [[SparkSession]]
    * @return a completion promise
    */
  def setActiveSession(session: SparkSession): js.Promise[Unit] = js.native

  /**
    * Sets the default SparkSession that is returned by the builder.
    * @param session the given [[SparkSession]]
    * @return a completion promise
    */
  def setDefaultSession(session: SparkSession): js.Promise[Unit] = js.native

}

