package wiggly.aoc2015.solution

import cats.effect.Sync
import wiggly.aoc2015.domain.Day01._

class Day01A[F[_]: Sync] {
  def solve(input: F[String]): F[Int] = {
    val instructions = parseInstructions(input)

    instructions
      .map({
        case Up => 1
        case Down => -1
      })
      .fold(0)(_ + _)
      .compile
      .lastOrError
  }

  def solveSimple(input: String): Int = {
    val instructions = parseInstructionsSimple(input)

    instructions
      .map({
        case Up => 1
        case Down => -1
      })
      .sum
  }
}
