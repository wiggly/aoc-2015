package wiggly.aoc2015.domain

import cats.data.Validated
import cats.data.ValidatedNel
import cats.implicits._
import cats.effect.Sync
import fs2.Pipe

import scala.util.Try

object Day02 {
  final case class Box(length: Int, width: Int, height: Int)

  val boxInputRx = raw"(\d+)x(\d+)x(\d+)".r

  def lineToBox(line: String): ValidatedNel[String, Box] =
    line match {
      case boxInputRx(parsedLength,parsedWidth,parsedHeight) =>
        (
          validateParsedInt(parsedLength),
          validateParsedInt(parsedWidth),
          validateParsedInt(parsedHeight)
        ).mapN((length, width, height) => Box(length, width, height))
      case _ =>
        Validated.invalidNel(s"Cannot parse string as Box - '$line'")
    }

  def validateParsedInt(string: String): ValidatedNel[String, Int] =
    Validated.fromTry(Try(string.toInt)).leftMap(_.getMessage).toValidatedNel

  def parseBoxes[F[_]](implicit F: Sync[F]): Pipe[F, String, Box] = {
    lines => lines
      .map(lineToBox)
      .evalMap[F,Box](validated =>
      validated.fold(
        errs => F.raiseError(new Exception(errs.toList.mkString("\n"))),
        box => F.pure(box)
      )
    )
  }

  def parseBoxesSimple(input: List[String]): List[Box] = {
    input
      .traverse(lineToBox)
      .fold(
        errs => throw new Exception(errs.toList.mkString("\n")),
        boxes => boxes
      )
  }
}
