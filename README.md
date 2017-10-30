Spark API for Scala.js
================================
[eclairjs](https://www.npmjs.com/package/eclairjs) - A JavaScript and Node.js API for Apache Spark.

### Description

EclairJS provides JavaScript and Node.js developers with an API for Apache Spark, and enables them to take advantage 
of Spark's unique data-processing environment that includes streaming, SQL, Machine Learning, and a graph database. 
Using EclairJS, developers can write applications entirely in JavaScript, some of which will be executed in the local 
JavaScript environment such as Node.js, and some of which will be executed on Spark. EclairJS is composed of a client 
component that runs in the local JavaScript environment, and can be simply installed from npm, and server components 
that can be remote from the client and handle JavaScript in Spark.

The examples directory contains smaller code examples that demonstrate how-to take advantage of various Spark 
capabilities such as streaming, ML, from a Node.js environment. There is also an examples/server directory that 
contains smaller code examples that can be run directly on the EclairJS server.

### Build Requirements

* [SBT v0.13.16](http://www.scala-sbt.org/download.html)


### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

### Examples

The following example is the Spark Big Data Hello World:

```scala
import io.scalajs.nodejs.console
import io.scalajs.spark.Implicits._
import io.scalajs.util.PromiseHelper.Implicits._

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js.JSConverters._

implicit val spark = Spark()

val sc = spark.SparkContext("local[*]", "Simple Word Count")

val textFile = sc.textFile("foo.txt")

val words = textFile.flatMap(_.split(" ").toJSArray)

val wordsWithCount = words.mapToPair(word => (word, 1))

val reducedWordsWithCount = wordsWithCount.reduceByKey((value1, value2) => value1 + value2)

reducedWordsWithCount.collect() foreach { results =>
  console.log("Word Count:", results)
  sc.stop()
}
```

The following is the original JavaScript version of the same example:

```javascript
var eclairjs = require('eclairjs');

var spark = new eclairjs();

var sc = new spark.SparkContext("local[*]", "Simple Word Count");

var textFile = sc.textFile('foo.txt');

var words = textFile.flatMap(function(sentence) {
  return sentence.split(" ");
});

var wordsWithCount = words.mapToPair(function(word, Tuple2) {
  return new Tuple2(word, 1);
}, [eclairjs.Tuple2]);

var reducedWordsWithCount = wordsWithCount.reduceByKey(function(value1, value2) {
  return value1 + value2;
});

reducedWordsWithCount.collect().then(function(results) {
  console.log('Word Count:', results);
  sc.stop();
});
```

### Artifacts and Resolvers

To add the `Spark` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "eclairjs" % "0.4.2"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 
```
