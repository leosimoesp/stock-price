import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.2",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Stock Price Akka",
    libraryDependencies += scalaTest % Test
  )

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"


libraryDependencies ++= Seq(
	"com.typesafe.akka" %% "akka-actor" % "2.5.1",
	"com.typesafe.akka" %% "akka-testkit" % "2.5.1" % "test",
	"junit" % "junit" % "4.11" % "test",
	"com.novocode" % "junit-interface" % "0.10" % "test",
	"org.scalactic" %% "scalactic" % "3.0.1",
	"org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
