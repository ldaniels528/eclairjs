package io.scalajs

import io.scalajs.util.ScalaJsHelper._

/**
  * spark package object
  * @author lawrence.daniels@gmail.com
  */
package object spark {

  /**
    * Spark Conf Constructor
    * @param `class` the given SparkConf class reference
    */
  final implicit class SparkConfConstructor(val `class`: SparkConfClass) extends AnyVal {

    @inline
    def apply(master: String, name: String): SparkConf = `class`.New(master, name)
  }

  /**
    * Spark Context Constructor
    * @param `class` the given SparkContext class reference
    */
  final implicit class SparkContextConstructor(val `class`: SparkContextClass) extends AnyVal {

    @inline
    def apply(master: String, name: String): SparkContext = `class`.New(master, name)
  }

  /**
    * Spark Implicit Conversions
    */
  object Implicits {

    implicit def tuple2ToSpark[A, B](tuple: (A, B)): Tuple2[A, B] = new Tuple2(tuple._1, tuple._2)

    implicit def sparkToTuple2[A, B](tuple: Tuple2[A, B]): (A, B) = (tuple._1, tuple._2)

  }

}
