package wiggly.aoc2015.solution

import cats.effect.IO
import org.scalatest.funspec.AnyFunSpec
import wiggly.aoc2015.util.InputHelper.inputLine

class Day01BSpec extends AnyFunSpec {

  describe("Day 1B") {
    describe("when given small input") {
      val input = inputLine[IO]("day01.small")
      val result = subject(input)
      it("succeeds") {
        assert(result == 1)
      }
    }

    describe("when given real input") {
      val input = inputLine[IO]("day01")
      val result = subject(input)
      it("succeeds") {
        assert(result == 1797)
      }
    }
  }

  describe("Day 1B Simple") {
    describe("when given small input") {
      val input = inputLine[IO]("day01.small")
      val result = subjectSimple(input)
      it("succeeds") {
        assert(result == 1)
      }
    }

    describe("when given real input") {
      val input = inputLine[IO]("day01")
      val result = subjectSimple(input)
      it("succeeds") {
        assert(result == 1797)
      }
    }
  }

  private def subject(input: IO[String]): Long = {
    (new Day01B[IO]).solve(input).unsafeRunSync()
  }

  private def subjectSimple(input: IO[String]): Long = {
    (new Day01B[IO]).solveSimple(input.unsafeRunSync())
  }
}
