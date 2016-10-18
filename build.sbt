name := "yaol"

version := "0.1"

scalaVersion := "2.11.8"
lazy val akkaVersion = "2.4.11"

fork in Test := true

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)
