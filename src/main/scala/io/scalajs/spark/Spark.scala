package io.scalajs.spark

import io.scalajs.util.ScalaJsHelper._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Spark Instance
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Spark extends js.Object {

  val SparkConf: SparkConfClass = js.native

  val SparkContext: SparkContextClass = js.native

  val Tuple: TupleClass = js.native

  val Tuple2: Tuple2Class = js.native

  val Tuple3: Tuple3Class = js.native

  val Tuple4: Tuple4Class = js.native

}

/**
  * Spark Module
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport(module = "eclairjs", JSImport.Namespace)
object Spark extends js.Object {

  def apply(): Spark = this.New()

}

/**
  * SparkConf class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SparkConfClass extends js.Object

/**
  * SparkContext class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait SparkContextClass extends js.Object

@js.native
trait TupleClass extends js.Object

/**
  * Tuple2 class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Tuple2Class extends TupleClass

/**
  * Tuple3 class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Tuple3Class extends TupleClass

/**
  * Tuple4 class
  * @author lawrence.daniels@gmail.com
  */
@js.native
trait Tuple4Class extends TupleClass