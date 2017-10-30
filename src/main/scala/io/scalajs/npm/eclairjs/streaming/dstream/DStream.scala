package io.scalajs.npm.eclairjs.streaming.dstream

import scala.scalajs.js

/**
  * DStream
  * @see https://eclairjs.github.io/eclairjs/client/docs/jsdoc/module-eclairjs_streaming_dstream.DStream.html
  */
@js.native
trait DStream extends js.Object {

  /**
    * Return a new DStream containing only the elements that satisfy a predicate.
    * @param func     the given function
    * @param bindArgs the array whose values will be added to func's argument list.
    * @return a [[DStream]]
    */
  def filter[T <: js.Any](func: js.Function1[T, Boolean], bindArgs: js.Array[T] = js.native): this.type = js.native

  /**
    * Return a new DStream by first applying a function to all elements of this DStream, and then flattening the results.
    * @param func     the given function
    * @param bindArgs the array whose values will be added to func's argument list.
    * @return a [[DStream]]
    */
  def flatMap[T <: js.Any](func: js.Function, bindArgs: js.Array[T] = js.native): this.type = js.native

}
