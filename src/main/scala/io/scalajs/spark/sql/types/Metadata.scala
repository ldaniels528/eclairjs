package io.scalajs.spark.sql.types

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Metadata is a wrapper over Map[String, Any] that limits the value type to simple ones: Boolean, Long, Double,
  * String, Metadata, Array[Boolean], Array[Long], Array[Double], Array[String], and Array[Metadata]. JSON is used
  * for serialization. The default constructor is private. User should use either MetadataBuilder or Metadata.fromJson()
  * to create Metadata instances.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
class Metadata protected() extends js.Object {

  /**
    * Gets a String.
    * @param key
    * @return
    */
  def getString(key: String): String = js.native

  /**
    * Converts to its JSON representation.
    * @return a JSON string
    */
  def json(): String = js.native

}

/**
  * Metadata Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
object Metadata extends js.Object {

  /**
    * Returns an empty Metadata.
    * @return the [[Metadata]]
    */
  def empty(): Metadata = js.native

}