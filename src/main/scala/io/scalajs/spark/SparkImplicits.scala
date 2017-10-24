package io.scalajs.spark

import io.scalajs.spark.sql.Column

/**
  * Spark Implicits
  * @author lawrence.daniels@gmail.com
  */
class SparkImplicits(val spark: Spark) {

}

/**
  * Spark Implicits Companion
  * @author lawrence.daniels@gmail.com
  */
object SparkImplicits {

  final implicit class ColumnEnrich(val sc: StringContext) extends AnyVal {

    @inline
    def $(args: Any*)(implicit spark: Spark): Column = spark.sql.functions.col(sc.s(args))

  }

}