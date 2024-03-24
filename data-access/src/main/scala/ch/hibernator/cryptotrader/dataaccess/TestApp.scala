package ch.hibernator.cryptotrader.dataaccess

import cats.*
import cats.effect.*
import cats.implicits.*
import cats.data.*
import org.http4s.*
import org.http4s.client.Client
import org.http4s.dsl.io.*
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.implicits.uri
import org.typelevel.log4cats.LoggerFactory
import org.typelevel.log4cats.slf4j.Slf4jFactory
import org.http4s.EntityDecoder.*

import java.io.File
import java.nio.file.{ Files, Paths }

object TestApp extends IOApp.Simple {

  implicit private val loggerFactory: LoggerFactory[IO] =
    Slf4jFactory.create[IO]

  private val uri: Uri = uri"https://data.binance.vision/data/spot/monthly/klines/BTCEUR/1h/BTCEUR-1h-2024-01.zip"

  private val client: Resource[IO, Client[IO]] = EmberClientBuilder.default[IO].build

  private def printHello(client: Client[IO]): IO[Unit] =
    client
      .expect[String](uri)
      .flatMap(IO.println)

//  private val printIo: IO[Unit] = client.use(client => printHello(client))
  private val printIo: IO[Unit] = client.use { client =>
    client.expect[Array[Byte]](uri).flatMap { file =>
      IO {
        Files.write(Paths.get("./BTCEUR-1h-2024-01.zip"), file)
      }
    }
  }

  override val run: IO[Unit] = printIo
}
