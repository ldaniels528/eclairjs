package io.scalajs.spark.sql.types

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * A field inside a StructType.
  * @param fieldName The name of this field.
  * @param dataType  The data type of this field.
  * @param nullable  Indicates if values of this field can be null values.
  * @param metadata  The metadata of this field. The metadata should be preserved during transformation if the
  *                  content of the column is not modified, e.g, in selection.
  */
@js.native
@JSGlobal
class StructField(fieldName: String, dataType: DataTypes, nullable: Boolean, metadata: Metadata) extends js.Object {

  def name(): String = js.native

}
