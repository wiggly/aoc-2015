package wiggly.aoc2015.solution

import cats.effect.IO
import org.scalatest.funspec.AnyFunSpec
import wiggly.aoc2015.util.InputHelper._
import fs2.Stream

class Day02ASpec extends AnyFunSpec {

  describe("Day 2A") {
    describe("when given small input") {
      val input = inputLines[IO]("day02.small")
      val result = subject(input)
      it("succeeds") {
        assert(result == 58)
      }
    }

    describe("when given real input") {
      val input = inputLines[IO]("day02")
      val result = subject(input)
      it("succeeds") {
        assert(result == 1598415)
      }
    }
  }

  describe("Day 2A Simple") {
    describe("when given small input") {
      val input = inputLines[IO]("day02.small")
      val result = subjectSimple(input)
      it("succeeds") {
        assert(result == 58)
      }
    }

    describe("when given real input") {
      val input = inputLines[IO]("day02")
      val result = subjectSimple(input)
      it("succeeds") {
        assert(result == 1598415)
      }
    }
  }

  private def subject(input: Stream[IO, String]): Int = {
    (new Day02A[IO]).solve(input).unsafeRunSync()
  }

  private def subjectSimple(input: Stream[IO, String]): Int = {
    (new Day02A[IO]).solveSimple(input.compile.toList.unsafeRunSync())
  }
}
