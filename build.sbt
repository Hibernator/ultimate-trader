import sbt.Keys.*
import sbt.*
import Settings.*

lazy val root = (project in file("."))
  .aggregate(traderCommon, dataAccess)
  .settings(standardSettings)
  .settings(noPublishSettings)
  .settings(
    name         := "ultimate-trader",
    scalaVersion := "3.4.0"
  )

lazy val traderCommon = (project in file("trader-common"))
  .settings(standardSettings)
  .settings(
    name := "trader-common",
    libraryDependencies ++= Seq(
      Dependencies.Ta4j,
      Dependencies.PureConfig
    ) ++ Dependencies.Http4s ++ Dependencies.Logging
  )

lazy val dataAccess = (project in file("data-access"))
  .dependsOn(traderCommon)
  .settings(standardSettings)
  .settings(
    name := "data-access"
  )
