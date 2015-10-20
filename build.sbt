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

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

bintrayReleaseOnPublish in ThisBuild := false

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
