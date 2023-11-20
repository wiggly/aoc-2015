package wiggly.aoc2015.solution

import cats.implicits._
import cats.effect.Sync
import fs2.Stream
import wiggly.aoc2015.domain.Day02._

class Day02A[F[_]: Sync] {
  def solve(input: Stream[F, String]): F[Int] = {
    val boxes = input.through(parseBoxes)

    boxes.map(box => {
      val faces = List(
        box.length * box.width,
        box.width * box.height,
        box.height * box.length
      )
      val smallest = faces.min

      faces.sum * 2 + smallest
    }).fold(0)(_ + _)
      .compile
      .lastOrError
  }

  def solveSimple(input: List[String]): Int = {
    val boxes = parseBoxesSimple(input)

    boxes.map(box => {
        val faces = List(
          box.length * box.width,
          box.width * box.height,
          box.height * box.length
        )
        val smallest = faces.min

        faces.sum * 2 + smallest
      }).sum
  }
}
