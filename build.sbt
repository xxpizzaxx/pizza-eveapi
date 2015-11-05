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

resolvers += Resolver.bintrayRepo("andimiller", "maven")

val slickVersion = "3.2.1000"

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
  "org.slf4j"                    % "slf4j-simple"              % "1.7.12",
  "com.typesafe.slick"           %% "slick"                    % slickVersion,
  "com.typesafe.slick"           %% "slick-codegen"            % slickVersion,
  "org.xerial"                   % "sqlite-jdbc"               % "3.6.20"
)

libraryDependencies ++= Seq (
  "org.scalatest"          %% "scalatest" % "2.2.4" % "test",
  "com.github.tomakehurst" % "wiremock"   % "1.33"  % "test"
)

lazy val slickGenerate = taskKey[Seq[File]]("slick code generation")

slickGenerate := {
  val url = "jdbc:sqlite:/home/andi/eve.db"
  val jdbcDriver = "com.sqlite.Driver"
  val slickDriver = "scala.slick.driver.SQLiteDriver"
  val targetPackageName = "moe.pizza.sdeapi"
  val outputDir = ((sourceManaged in Compile).value / "eve.db").getPath // place generated files in sbt's managed sources folder
  val fname = outputDir + s"/$targetPackageName/Tables.scala"
  println(s"\nauto-generating slick source for database schema at $url...")
  println(s"output source file file: file://$fname\n")
  (runner in Compile).value.run("scala.slick.codegen.SourceCodeGenerator", (dependencyClasspath in Compile).value.files, Array(slickDriver, jdbcDriver, url, outputDir, targetPackageName), streams.value.log)
  Seq(file(fname))
}


ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

bintrayReleaseOnPublish in ThisBuild := true

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
