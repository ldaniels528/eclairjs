package io.scalajs.spark

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * A Resilient Distributed Dataset (RDD), the basic abstraction in Spark. Represents an immutable, partitioned
  * collection of elements that can be operated on in parallel.
  * @see https://eclairjs.github.io/eclairjs/client/docs/jsdoc/module-eclairjs_rdd.RDD.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait RDD[T] extends js.Object {

  /**
    * Persist this RDD with the default storage level (`MEMORY_ONLY`).
    * @return the [[RDD]]
    */
  def cache(): this.type = js.native

  /**
    * Asynchronously returns all elements of the RDD.
    * @return A Promise that resolves to an array containing all elements in the RDD.
    */
  def collect(): js.Promise[js.Array[T]] = js.native

  /**
    * Asynchronously returns the number of elements in the RDD.
    * @return A Promise that resolves to the number of elements in the RDD.
    */
  def count(): js.Promise[Double] = js.native

  /**
    * Return a new RDD containing only the elements that satisfy a predicate.
    * @param v        function with one parameter
    * @param bindArgs array whose values will be added to func's argument list.
    * @return
    */
  def filter(v: T => Boolean, bindArgs: js.Array[T] = js.native): RDD[T] = js.native

  def flatMap[U](v: T => js.Array[U], bindArgs: js.Array[U] = js.native): RDD[U] = js.native

  def foreach(v: T => Any, bindArgs: js.Array[T] = js.native): Unit = js.native

  def map[U](v: T => U, bindArgs: js.Array[U] = js.native): RDD[U] = js.native

  @JSName("mapToPair")
  def mapToPairJS[U](v: T => Tuple2[T, U], `class`: TupleClass): RDD2[T, U] = js.native

  /**
    * Save this RDD as a SequenceFile of serialized objects.
    * @param path      the output path
    * @param overwrite defaults to false, if true overwrites file if it exists
    * @return a completion process
    */
  def saveAsObjectFile(path: String, overwrite: Boolean = js.native): js.Promise[Unit] = js.native

  /**
    * Return the union of this RDD and another one. Any identical elements will appear multiple times (use `.distinct()` to eliminate them).
    * @param other the RDD to union
    * @return a composite [[RDD]]
    */
  def union[U, V](other: RDD[V]): RDD[U] = js.native

  /**
    * Return an RDD with the values of each tuple.
    * @return a [[RDD]]
    */
  def values(): RDD[T] = js.native

  /**
    * Zips this RDD with its element indices. The ordering is first based on the partition index and then the ordering
    * of items within each partition. So the first item in the first partition gets index 0, and the last item in the
    * last partition receives the largest index. This is similar to Scala's zipWithIndex but it uses Long instead of
    * Int as the index type. This method needs to trigger a spark job when this RDD contains more than one partitions.
    * Note that some RDDs, such as those returned by groupBy(), do not guarantee order of elements in a partition.
    * The index assigned to each element is therefore not guaranteed, and may even change if the RDD is reevaluated.
    * If a fixed ordering is required to guarantee the same index assignments, you should sort the RDD with sortByKey()
    * or save it to a file.
    * @return a [[RDD]]
    */
  def zipWithIndex(): RDD2[T, Int] = js.native

}

/**
  * RDD Companion
  * @author lawrence.daniels@gmail.com
  */
object RDD {

  final implicit class RDDEnrichment[T](val rdd: RDD[T]) extends AnyVal {

    @inline
    def mapToPair[U](v: T => Tuple2[T, U])(implicit spark: Spark): RDD2[T, U] = {
      rdd.mapToPairJS(v, spark.Tuple2)
    }
  }

}

/**
  * Resilient Distributed Data (RDD) of Tuple2
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait RDD2[A, B] extends RDD[(A, B)] {

  def reduceByKey[U](f: (A, B) => U): RDD[U] = js.native

}

/**
  * Resilient Distributed Data (RDD) of Tuple3
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait RDD3[A, B, C] extends RDD[(A, B, C)] {

  def reduceByKey[U](f: (A, B, C) => U): RDD[U] = js.native

}

/**
  * Resilient Distributed Data (RDD) of Tuple4
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait RDD4[A, B, C, D] extends RDD[(A, B, C, D)] {

  def reduceByKey[U](f: (A, B, C, D) => U): RDD[U] = js.native

}