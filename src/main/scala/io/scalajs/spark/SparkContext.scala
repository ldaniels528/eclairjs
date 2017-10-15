package io.scalajs.spark

import scala.scalajs.js

/**
  * Spark Context
  * @param master the given Spark master node
  * @param name   the given application name/descriptor
  */
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

  def applicationId(): js.Promise[String] = js.native

  def appName(): js.Promise[String] = js.native

  def broadcast(value: js.Any): Unit = js.native

  def getLocalProperty(key: String): js.Promise[String] = js.native

  def isLocal(): js.Promise[Boolean] = js.native

  def isStopped(): js.Promise[Boolean] = js.native

  def parallelize[T](list: js.Array[T], numSlices: Int = js.native): RDD[T] = js.native

  def parallelizePairs[T](list: js.Array[T], numSlices: Int = js.native): RDD[T] = js.native

  def textFile(path: String): RDD[String] = js.native

  def stop(): Unit = js.native

}
