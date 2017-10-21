package io.scalajs.spark.sql.types

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import scala.scalajs.js.|

/**
  * For a StructType object, one or multiple StructFields can be extracted by names. If multiple StructFields are
  * extracted, a StructType object will be returned. If a provided name does not have a matching field, it will be
  * ignored.
  * @see https://eclairjs.github.io/eclairjs/client/docs/jsdoc/module-eclairjs_sql_types.StructType.html
  */
@js.native
@JSGlobal
class StructType(fields: js.Array[StructField]) extends js.Object {

  /**
    * Creates a new StructType by adding a new nullable field with no metadata.
    * @param name     the field name
    * @param dataType the field's data type
    * @param nullable defaults true, nullable field
    * @param metadata defaults to null, specifying metadata
    * @return a [[StructType]]
    */
  def add(name: String, dataType: DataTypes, nullable: Boolean = js.native, metadata: Metadata = js.native): this.type = js.native

  /**
    * Extracts a StructField of the given name or index.
    * @param field the field index or name
    * @return a [[StructField]]
    */
  def apply(field: String | Int): StructField = js.native

  /**
    * The default size of a value of the StructType is the total default sizes of all field types.
    * @return The default size
    */
  def defaultSize(): Int = js.native

  /**
    * Returns index of a given field
    * @param name the field index or name
    * @return the field index
    */
  def fieldIndex(name: String): Int = js.native

  /**
    *
    * @return
    */
  def length(): Int = js.native

  /**
    *
    */
  def printTreeString(): Unit = js.native

  /**
    * Readable string representation for the type.
    * @return a string
    */
  def simpleString(): String = js.native

  /**
    *
    * @return
    */
  def treeString(): String = js.native

}
