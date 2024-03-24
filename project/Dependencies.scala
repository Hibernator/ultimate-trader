import sbt.*

object Dependencies {

  object Version {
    val Ta4J          = "0.15"
    val PureConfig    = "0.17.6"
    val Http4s        = "0.23.26"
    val Slf4j         = "2.0.12"
    val Logback       = "1.5.3"
    val Log4CatsSlf4j = "2.6.0"
  }

  val Ta4j       = "org.ta4j"               % "ta4j-core"  % Version.Ta4J
  val PureConfig = "com.github.pureconfig" %% "pureconfig" % Version.PureConfig cross CrossVersion.for3Use2_13

  val Http4s: Seq[ModuleID] = Seq(
    "org.http4s" %% "http4s-ember-client" % Version.Http4s,
    "org.http4s" %% "http4s-ember-server" % Version.Http4s,
    "org.http4s" %% "http4s-dsl"          % Version.Http4s
  )

  private val Slf4j          = "org.slf4j"      % "slf4j-api"       % Version.Slf4j
  private val Logback        = "ch.qos.logback" % "logback-classic" % Version.Logback
  private val Log4CatsSlf4j  = "org.typelevel" %% "log4cats-slf4j"  % Version.Log4CatsSlf4j
  val Logging: Seq[ModuleID] = Seq(Slf4j, Logback, Log4CatsSlf4j)

}
