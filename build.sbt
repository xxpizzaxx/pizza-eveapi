name := "eveapi"

organization := "moe.pizza"

scalaVersion := "2.11.7"

isSnapshot := true

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

lazy val buildSources = taskKey[Unit]("Execute the XML build script")

buildSources := {
  "./build.sh" !
}

compile <<= (compile in Compile) dependsOn buildSources
test <<= (test in Test) dependsOn buildSources

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.0.3"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3"
libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
libraryDependencies += "net.debasishg" %% "redisclient" % "3.0"
libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.10"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.6.1"
libraryDependencies += "joda-time" % "joda-time" % "2.8.2"
libraryDependencies += "org.joda" % "joda-convert" % "1.2"


libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
libraryDependencies += "com.github.tomakehurst" % "wiremock" % "1.33" % "test"

bintrayReleaseOnPublish in ThisBuild := true

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
