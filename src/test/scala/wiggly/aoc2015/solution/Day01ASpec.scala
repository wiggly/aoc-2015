package wiggly.aoc2015.solution

import cats.effect.IO
import org.scalatest.funspec.AnyFunSpec
import wiggly.aoc2015.util.InputHelper.inputLine

class Day01ASpec extends AnyFunSpec {

  describe("Day 1A") {
    describe("when given small input") {
      val input = inputLine[IO]("day01.small")
      val result = subject(input)
      it("succeeds") {
        assert(result == -3)
      }
    }

    describe("when given real input") {
      val input = inputLine[IO]("day01")
      val result = subject(input)
      it("succeeds") {
        assert(result == 280)
      }
    }
  }

  describe("Day 1A Simple") {
    describe("when given small input") {
      val input = inputLine[IO]("day01.small")
      val result = subjectSimple(input)
      it("succeeds") {
        assert(result == -3)
      }
    }

    describe("when given real input") {
      val input = inputLine[IO]("day01")
      val result = subjectSimple(input)
      it("succeeds") {
        assert(result == 280)
      }
    }
  }

  private def subject(input: IO[String]): Int = {
    (new Day01A[IO]).solve(input).unsafeRunSync()
  }

  private def subjectSimple(input: IO[String]): Int = {
    (new Day01A[IO]).solveSimple(input.unsafeRunSync())
  }
}
