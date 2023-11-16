package wiggly.aoc2015.util

import cats.effect.Sync
import fs2.Stream

import scala.io.Source

object InputHelper {

  def inputResourceLines[F[_]: Sync](name: String): Stream[F, String] =
    Stream.fromIterator(Source.fromResource(s"input/$name", getClass.getClassLoader).getLines())

  def inputLine[F[_]: Sync](name: String): F[String] =
    inputResourceLines[F](name).compile.lastOrError
}
