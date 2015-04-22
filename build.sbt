lazy val scalatraVersion = "2.3.1"


lazy val root = (project in file(".")).settings(
  organization := "com.example",
  name := "scalatra-sbt-prototype",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.11.6",
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
  libraryDependencies ++= Seq(
    "org.scalatra"      %% "scalatra"          % scalatraVersion,
    "org.scalatra"      %% "scalatra-scalate"  % scalatraVersion,
    "org.scalatra"      %% "scalatra-json"     % scalatraVersion,
    "org.json4s"        %% "json4s-jackson"    % "3.2.11",
    "org.json4s"        %% "json4s-ext"        % "3.2.11",
    "ch.qos.logback"    %  "logback-classic"   % "1.1.3"            % "runtime",
    "org.eclipse.jetty" %  "jetty-webapp"      % "9.2.10.v20150310" % "compile",
    "javax.servlet"     %  "javax.servlet-api" % "3.1.0"            % "provided",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
    "org.scalatra"      %% "scalatra-scalatest" % scalatraVersion % "test"
  ),
  Revolver.settings
).settings(jetty(): _*)


