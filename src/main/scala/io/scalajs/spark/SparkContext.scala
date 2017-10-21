package io.scalajs.spark

import io.scalajs.spark.sql.DataFrameReader

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * A JavaScript-friendly version of SparkContext that returns RDDs Only one SparkContext may be active per JVM.
  * You must stop() the active SparkContext before creating a new one. This limitation may eventually be removed;
  * see SPARK-2243 for more details.
  * @param master the given Spark master node
  * @param name   the given application name/descriptor
  */
@JSGlobal
@js.native
class SparkContext(master: String, name: String) extends js.Object {

  /**
    * Create an Accumulable shared variable of the given type, to which tasks can "add" values with add.
    * Only the master can access the accumuable's value.
    * @param initialValue the initial value
    * @param param        the parameter
    * @param name         the name
    * @return an [[Accumulable]]
    */
  def accumulable(initialValue: js.Any, param: js.Any, name: String): Accumulable = js.native

  /**
    * Create an Accumulator variable, which tasks can "add" values to using the add method.
    * Only the master can access the accumulator's value.
    * @param initialValue the initial value
    * @param name         the name
    * @param param        the parameter
    * @return an [[Accumulator]]
    */
  def accumulator(initialValue: js.Any, name: String = js.native, param: js.Any = js.native): Accumulator = js.native

  /**
    *
    * @return
    */
  def applicationId(): js.Promise[String] = js.native

  /**
    *
    * @return
    */
  def appName(): js.Promise[String] = js.native

  /**
    *
    * @param value
    */
  def broadcast(value: js.Any): Unit = js.native

  /**
    *
    * @param key
    * @return
    */
  def getLocalProperty(key: String): js.Promise[String] = js.native

  /**
    *
    * @return
    */
  def isLocal(): js.Promise[Boolean] = js.native

  /**
    *
    * @return
    */
  def isStopped(): js.Promise[Boolean] = js.native

  /**
    *
    * @return
    */
  def read: DataFrameReader = js.native

  /**
    *
    * @param list
    * @param numSlices
    * @tparam T
    * @return
    */
  def parallelize[T](list: js.Array[T], numSlices: Int = js.native): RDD[T] = js.native

  /**
    *
    * @param list
    * @param numSlices
    * @tparam T
    * @return
    */
  def parallelizePairs[T](list: js.Array[T], numSlices: Int = js.native): RDD[T] = js.native

  /**
    * Read a text file from HDFS, a local file system (available on all nodes), or any Hadoop-supported file system URI,
    * and return it as an RDD of Strings.
    * @param path path to file
    * @return an [[RDD]]
    */
  def textFile(path: String): RDD[String] = js.native

  /**
    * 
    */
  def stop(): Unit = js.native

  /**
    * Read a directory of text files from HDFS, a local file system (available on all nodes), or any Hadoop-supported
    * file system URI. Each file is read as a single record and returned in a key-value pair, where the key is the path
    * of each file, the value is the content of each file.
    * @param path          Directory to the input data files, the path can be comma separated paths as the list of inputs.
    * @param minPartitions A suggestion value of the minimal splitting number for input data.
    * @return an [[RDD]]
    */
  def wholeTextFiles(path: String, minPartitions: Int): RDD[String] = js.native

}
