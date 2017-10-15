package io.scalajs.spark

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

/**
  * Resilient Distributed Data (RDD)
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait RDD[T] extends js.Object {

  def cache(): this.type = js.native

  def collect(): js.Promise[js.Array[T]] = js.native

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