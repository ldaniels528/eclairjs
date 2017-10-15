package io.scalajs.spark

import io.scalajs.nodejs.util.Util
import org.scalatest.FunSpec

/**
  * Spark Tests
  * @author lawrence.daniels@gmail.com
  */
class SparkTest extends FunSpec {

  describe("Spark") {

    it("should create a Spark instance") {
      val spark = Spark()
      info(Util.inspect(spark))
    }

  }

}
