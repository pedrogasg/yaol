name := "yaol"

version := "0.1"

scalaVersion := "2.11.8"
lazy val akkaVersion = "2.4.11"

fork in Test := true

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
  "org.pegdown" % "pegdown" % "1.6.0" % "test",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)
