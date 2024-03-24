import sbt.Keys.*
import sbt.{ Def, * }

object Settings {

  val noPublishSettings: Seq[Def.Setting[Task[Unit]]] = Seq(
    publishLocal := {},
    publish      := {}
  )

  val standardSettings = Seq(
    organization := "ch.hibernator.cryptotrader",
    scalaVersion := "3.4.0",
    scalacOptions := Seq(
      "-encoding",
      "utf8",
      "-language: implicitConversions",
      "-language:postfixOps",
      "-language:existentials",
      "-language:higherKinds",
      "-explaintypes",
      "-feature",
      "-deprecation",
      "-Xlint:private-shadow"
    )
  )
}
