package io.scalajs.npm.eclairjs.streaming.kafka

import io.scalajs.npm.eclairjs.streaming.StreamingContext
import io.scalajs.npm.eclairjs.streaming.dstream.DStream

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@JSGlobal
@js.native
object KafkaUtils extends js.Object {

  /**
    * NOTE: This currently only works on Kafka key/values which are Strings Create an input stream that directly pulls
    * messages from Kafka Brokers without using any receiver. This stream can guarantee that each message from Kafka is
    * included in transformations exactly once (see points below). Points to note: - No receivers: This stream does not
    * use any receiver. It directly queries Kafka - Offsets: This does not use Zookeeper to store offsets. The consumed
    * offsets are tracked by the stream itself. For interoperability with Kafka monitoring tools that depend on Zookeeper,
    * you have to update Kafka/Zookeeper yourself from the streaming application. You can access the offsets used in
    * each batch from the generated RDDs (see HasOffsetRanges). - Failure Recovery: To recover from driver failures,
    * you have to enable checkpointing in the StreamingContext. The information on consumed offset can be recovered
    * from the checkpoint. See the programming guide for details (constraints, etc.). - End-to-end semantics: This
    * stream ensures that every records is effectively received and transformed exactly once, but gives no guarantees
    * on whether the transformed data are outputted exactly once. For end-to-end exactly-once semantics, you have to
    * either ensure that the output operation is idempotent, or use transactions to output records atomically.
    * See the programming guide for more details.
    * @param ssc         the [[StreamingContext streaming context]]
    * @param kafkaParams map of Kafka options (key, value). Kafka configuration parameters.
    *                    Requires "metadata.broker.list" or "bootstrap.servers" to be set with Kafka broker(s)
    *                    (NOT zookeeper servers), specified in host1:port1,host2:port2 form. If not starting from a
    *                    checkpoint, "auto.offset.reset" may be set to "largest" or "smallest" to determine where the
    *                    stream starts (defaults to "largest")
    * @param topics      the names of the topics to consume
    * @return the DStream of (Kafka message key, Kafka message value)
    */
  def createDirectStream[T <: js.Any](ssc: StreamingContext, kafkaParams: js.Dictionary[T], topics: js.Array[String]): DStream = js.native

}
