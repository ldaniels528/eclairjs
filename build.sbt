import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys.{libraryDependencies, _}
import sbt._

import scala.language.postfixOps

val scalaJsIOVersion = "0.4.2"
val apiVersion = scalaJsIOVersion
val scalaJsVersion = "2.12.3"

lazy val root = (project in file(".")).
  enablePlugins(ScalaJSPlugin).
  settings(
    name := "eclairjs",
    organization := "io.scalajs.npm",
    description := "Spark API for NodeJS",
    version := apiVersion,
    scalaVersion := scalaJsVersion,
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-language:implicitConversions", "-Xlint"),
    scalacOptions in(Compile, doc) ++= Seq("-no-link-warnings"),
    autoCompilerPlugins := true,
    scalaJSModuleKind := ModuleKind.CommonJSModule,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-reflect" % scalaJsVersion,
      "io.scalajs" %%% "nodejs-core" % scalaJsIOVersion,
      //
      // Testing
      "org.scalatest" %%% "scalatest" % "3.0.1" % "test",
      "io.scalajs" %%% "nodejs" % scalaJsIOVersion % "test"
    ))

/////////////////////////////////////////////////////////////////////////////////
//      Publishing
/////////////////////////////////////////////////////////////////////////////////

lazy val publishingSettings = Seq(
  sonatypeProfileName := "org.xerial",
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra :=
    <url>https://github.com/scalajs-io/eclairjs</url>
      <licenses>
        <license>
          <name>MIT License</name>
          <url>http://www.opensource.org/licenses/mit-license.php</url>
        </license>
      </licenses>
      <scm>
        <connection>scm:git:github.com/scalajs-io/eclairjs.git</connection>
        <developerConnection>scm:git:git@github.com:scalajs-io/eclairjs.git</developerConnection>
        <url>github.com/scalajs-io/spark.git</url>
      </scm>
      <developers>
        <developer>
          <id>ldaniels528</id>
          <name>Lawrence Daniels</name>
          <email>lawrence.daniels@gmail.com</email>
          <organization>io.scalajs</organization>
          <organizationUrl>https://github.com/scalajs-io</organizationUrl>
          <roles>
            <role>Project-Administrator</role>
            <role>Developer</role>
          </roles>
          <timezone>+7</timezone>
        </developer>
      </developers>
)

// loads the Scalajs-io root project at sbt startup
onLoad in Global := (Command.process("project root", _: State)) compose (onLoad in Global).value
