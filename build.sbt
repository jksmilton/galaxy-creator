val ScalatraVersion = "2.6.2"

organization := "me.jksmilton"

name := "Galaxy Creator"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.1"
scalacOptions += "-target:jvm-1.7"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "org.scalatra" %% "scalatra-json" % ScalatraVersion,
  "org.json4s"   %% "json4s-jackson" % "3.5.2",
  "ch.qos.logback" % "logback-classic" % "1.1.5" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.2.15.v20160210" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "com.github.jpbetz" % "subspace" % "0.1.0",
  "org.scala-lang" % "scala-library" % scalaVersion.value
)

enablePlugins(ScalatraPlugin)
