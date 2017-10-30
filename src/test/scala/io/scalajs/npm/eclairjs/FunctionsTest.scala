package io.scalajs.npm.eclairjs

import org.scalatest.FunSpec

/**
  * functions tests
  * @author lawrence.daniels@gmail.com
  */
class FunctionsTest extends FunSpec {

  describe("spark.sql.functions") {

    val spark = Spark()
    import spark.sql.functions

    it("should support sql.functions") {
      val col1 = functions.col("age")
      val col2 = functions.col("expense")
      var result = functions.atan2(col1, col2)
      info(s"result: $result")

      // or
      result = functions.atan2(col1, "name")
      info(s"result: $result")

      result = functions.atan2("age", col2)
      info(s"result: $result")

      result = functions.atan2("age", "expense")
      info(s"result: $result")

      result = functions.atan2(col1, 2.0)
      info(s"result: $result")

      result = functions.atan2("age", 2.0)
      info(s"result: $result")

      result = functions.atan2(2.0, col2)
      info(s"result: $result")

      result = functions.atan2(2.0, "expense")
      info(s"result: $result")
    }
  }

}
