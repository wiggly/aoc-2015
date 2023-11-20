package wiggly.aoc2015.solution

import cats.implicits._
import cats.effect.Sync
import fs2.Stream
import wiggly.aoc2015.domain.Day02._

class Day02B[F[_]: Sync] {
  def solve(input: Stream[F, String]): F[Int] = {
    val boxes = input.through(parseBoxes)

    boxes
      .map(computeBoxRibbon)
      .fold(0)(_ + _)
      .compile
      .lastOrError
  }

  def solveSimple(input: List[String]): Int = {
    val boxes = parseBoxesSimple(input)

    boxes
      .map(computeBoxRibbon)
      .sum
  }

  def computeBoxRibbon(box: Box): Int = {
    val sortedSides: Seq[Int] = List(box.width, box.height, box.length).sorted

    val smallestSides: Seq[Int] = sortedSides.take(2)

    val perimeterRibbon: Int = smallestSides.map(_ * 2).sum

    val bowRibbon: Int = sortedSides.product

    val totalRibbon: Int = perimeterRibbon + bowRibbon

    totalRibbon
  }
}
