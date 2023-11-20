package wiggly.aoc2015.solution

import cats.effect.IO
import org.scalatest.funspec.AnyFunSpec
import wiggly.aoc2015.util.InputHelper._
import fs2.Stream

class Day02BSpec extends AnyFunSpec {

  describe("Day 2B") {
    describe("when given small input") {
      val input = inputLines[IO]("day02.small")
      val result = subject(input)
      it("succeeds") {
        assert(result == 34)
      }
    }

    describe("when given real input") {
      val input = inputLines[IO]("day02")
      val result = subject(input)
      it("succeeds") {
        assert(result == 3812909)
      }
    }
  }

  describe("Day 2B Simple") {
    describe("when given small input") {
      val input = inputLines[IO]("day02.small")
      val result = subjectSimple(input)
      it("succeeds") {
        assert(result == 34)
      }
    }

    describe("when given real input") {
      val input = inputLines[IO]("day02")
      val result = subjectSimple(input)
      it("succeeds") {
        assert(result == 3812909)
      }
    }
  }

  private def subject(input: Stream[IO, String]): Int = {
    (new Day02B[IO]).solve(input).unsafeRunSync()
  }

  private def subjectSimple(input: Stream[IO, String]): Int = {
    (new Day02B[IO]).solveSimple(input.compile.toList.unsafeRunSync())
  }
}
