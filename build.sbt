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

libraryDependencies ++= Seq(
  "org.scala-lang.modules"       %% "scala-xml"                % "1.0.3",
  "org.scala-lang.modules"       %% "scala-parser-combinators" % "1.0.3",
  "net.databinder.dispatch"      %% "dispatch-core"            % "0.11.2",
  "net.debasishg"                %% "redisclient"              % "3.0",
  "org.json4s"                   %% "json4s-jackson"           % "3.2.10",
  "com.fasterxml.jackson.module" %% "jackson-module-scala"     % "2.6.1",
  "org.eclipse.jetty.websocket"  % "websocket-client"          % "9.3.5.v20151012",
  "joda-time"                    % "joda-time"                 % "2.8.2",
  "org.joda"                     % "joda-convert"              % "1.2",
  "org.slf4j"                    % "slf4j-simple"              % "1.7.12"
)

libraryDependencies ++= Seq (
  "org.scalatest"          %% "scalatest" % "2.2.4" % "test",
  "com.github.tomakehurst" % "wiremock"   % "1.33"  % "test"
)

ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

bintrayReleaseOnPublish in ThisBuild := true

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
