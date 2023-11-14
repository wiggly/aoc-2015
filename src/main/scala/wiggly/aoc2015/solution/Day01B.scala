package wiggly.aoc2015.solution

import cats.effect.Sync
import wiggly.aoc2015.domain.Day01._

class Day01B[F[_] : Sync] {
  def solve(input: F[String]): F[Long] = {
    val instructions = loadInstructions(input)

    instructions
      .map({
        case Up => 1
        case Down => -1
      })
      .scan(0)(_ + _)
      .zipWithIndex
      .takeThrough(_._1 != -1)
      .map(_._2)
      .compile
      .lastOrError
  }

  def solveBasic(input: String): Long = {
    val instructions = loadInstructionsBasic(input)

    instructions
      .map({
        case Up => 1
        case Down => -1
      })
      .scan(0)(_ + _)
      .zipWithIndex
      .dropWhile(_._1 != -1)
      .map(_._2)
      .head
      .toLong
  }
}
