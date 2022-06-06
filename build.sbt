import sbt.librarymanagement.ConflictWarning

enablePlugins(JavaAppPackaging)

name := "akka-http-microservice"
organization := "com.theiterators"
version := "1.0"
scalaVersion := "3.1.2"

conflictWarning := ConflictWarning.disable

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaHttpV      = "10.2.9"
  val akkaV          = "2.6.19"
  val scalaTestV     = "3.2.12"
  val circeV         = "0.14.1"
  val akkaHttpCirceV = "1.39.2"
  Seq(
    "io.featurehub.sdk" % "java-client-core" % "2.7",
    "io.featurehub.sdk" % "java-client-jersey" % "2.4",
    "org.apache.cassandra" % "cassandra-all" % "4.0.3",
  ) ++ Seq(
    "io.circe"          %% "circe-core" % circeV,
    "io.circe"          %% "circe-parser" % circeV,
    "io.circe"          %% "circe-generic" % circeV,
    "org.scalatest"     %% "scalatest" % scalaTestV % "test"
  ) ++ Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "de.heikoseeberger" %% "akka-http-circe" % akkaHttpCirceV,
    "com.typesafe.akka" %% "akka-testkit" % akkaV,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV % "test"
  ).map(_.cross(CrossVersion.for3Use2_13))
}

Revolver.settings
