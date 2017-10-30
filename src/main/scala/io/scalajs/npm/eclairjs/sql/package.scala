package io.scalajs.npm.eclairjs

/**
  * sql package object
  * @author lawrence.daniels@gmail.com
  */
package object sql {

  /**
    * A distributed collection of data organized into named columns. A DataFrame is equivalent to a relational table in Spark SQL.
    * @author lawrence.daniels@gmail.com
    */
  type DataFrame = DataSet[Row]

}
