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
libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.3"
resolvers += Resolver.bintrayRepo("andimiller", "maven")

val slickVersion = "3.0.1"
val HTTP4S_VERSION = "0.12.3"

val circeVersion = "0.4.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

libraryDependencies ++= Seq(
  "org.scala-lang.modules"       %% "scala-xml"                % "1.0.3",
  "org.scala-lang.modules"       %% "scala-parser-combinators" % "1.0.3",
  "net.databinder.dispatch"      %% "dispatch-core"            % "0.11.3",
  "org.http4s"                   %% "http4s-blaze-client"      % HTTP4S_VERSION,
  "net.debasishg"                %% "redisclient"              % "3.0",
  "org.json4s"                   %% "json4s-jackson"           % "3.2.10",
  "com.fasterxml.jackson.module" %% "jackson-module-scala"     % "2.6.1",
  "org.eclipse.jetty.websocket"  % "websocket-client"          % "9.3.5.v20151012",
  "joda-time"                    % "joda-time"                 % "2.8.2",
  "org.joda"                     % "joda-convert"              % "1.2",
  "org.slf4j"                    % "slf4j-simple"              % "1.7.12",
  "com.typesafe.slick"           %% "slick"                    % slickVersion,
  "com.typesafe.slick"           %% "slick-codegen"            % slickVersion,
  "mysql"                        % "mysql-connector-java"      % "5.1.37"
)

libraryDependencies ++= Seq (
  "org.scalatest"          %% "scalatest" % "2.2.4" % "test",
  "com.github.tomakehurst" % "wiremock"   % "1.33"  % "test"
)

lazy val slickGenerate = taskKey[Seq[File]]("slick code generation")

slickGenerate := {
  val url = "jdbc:mysql://localhost:3306/sde"
  val jdbcDriver = "com.mysql.jdbc.Driver"
  val slickDriver = "slick.driver.MySQLDriver"
  val targetPackageName = "moe.pizza.sdeapi"
  val outputDir = "./src/main/scala/"//((sourceManaged in Compile).value / "sde").getPath // place generated files in sbt's managed sources folder
  val fname = outputDir + s"/$targetPackageName/Tables.scala"
  println(s"\nauto-generating slick source for database schema at $url...")
  println(s"output source file file: file://$fname\n")
  (runner in Compile).value.run("slick.codegen.SourceCodeGenerator", (dependencyClasspath in Compile).value.files, Array(slickDriver, jdbcDriver, url, outputDir, targetPackageName, "sde", "sde"), streams.value.log)
  Seq(file(fname))
}

//compile <<= (compile in Compile) dependsOn slickGenerate


ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

bintrayReleaseOnPublish in ThisBuild := true

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
