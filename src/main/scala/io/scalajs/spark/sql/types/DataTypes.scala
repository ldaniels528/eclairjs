package io.scalajs.spark.sql.types

import scala.scalajs.js

/**
  * The base type of all Spark SQL data types.
  * @see https://eclairjs.github.io/eclairjs/client/docs/jsdoc/module-eclairjs_sql_types.DataTypes.html
  * @author lawrence.daniels@gmail.com
  */
@js.native
sealed trait DataTypes extends js.Object {

  ////////////////////////////////////////////////////////////////
  //    Constants
  ////////////////////////////////////////////////////////////////

  /**
    * Gets the BooleanType object.
    */
  val BooleanType: BooleanType = js.native

  /**
    * Gets the DateType object.
    */
  val DateType: DateType = js.native

  /**
    * Gets the DoubleType object.
    */
  val DoubleType: DoubleType = js.native

  /**
    * Gets the DoubleType object. Note: JavaScript float types are mapped to DoubleTypes in Spark,
    * The user should use the DoubleType for all float processing
    */
  val FloatType: FloatType = js.native

  /**
    * Gets the IntegerType object.
    */
  val IntegerType: IntegerType = js.native

  /**
    * Gets the StringType object.
    */
  val StringType: StringType = js.native

  ////////////////////////////////////////////////////////////////
  //    Methods
  ////////////////////////////////////////////////////////////////

  /**
    * Creates an ArrayType by specifying the data type of elements (elementType) and whether the array contains null values (containsNull).
    * @param elementType
    * @param containsNull
    * @return
    */
  def createArrayType(elementType: DataTypes, containsNull: Boolean = js.native): ArrayType = js.native

  /**
    * Creates a StructField with empty metadata.
    * @param fieldName
    * @param dataType
    * @param nullable
    * @return a [[StructField]]
    */
  def createStructField(fieldName: String, dataType: DataTypes, nullable: Boolean): StructField = js.native

  /**
    * Creates a StructType with the given StructField array (fields).
    * @param fields the given fields
    * @return a [[StructType]]
    */
  def createStructType(fields: js.Array[StructField]): StructType = js.native

}

@js.native
trait ArrayType extends DataTypes

@js.native
trait BooleanType extends DataTypes

@js.native
trait DateType extends DataTypes

@js.native
trait DoubleType extends DataTypes

@js.native
trait FloatType extends DataTypes

@js.native
trait IntegerType extends DataTypes

@js.native
trait StringType extends DataTypes

