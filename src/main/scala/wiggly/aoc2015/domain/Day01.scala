package wiggly.aoc2015.domain

import cats.effect.Sync
import fs2.Stream

object Day01 {

  sealed trait Instruction
  final case object Up extends Instruction
  final case object Down extends Instruction

  def loadInstructions[F[_]](line: F[String])(implicit F: Sync[F]): Stream[F, Instruction] = {
    Stream
      .eval(line)
      .flatMap(line => Stream.fromIterator(line.iterator))
      .evalMap[F, Instruction]({
        case '(' => F.pure(Up)
        case ')' => F.pure(Down)
        case x => F.raiseError(new Exception(s"Cannot parse input - '$x'"))
      })
  }

  def loadInstructionsBasic(line: String): List[Instruction] = {
    List.from(line.iterator)
      .map[Instruction]({
        case '(' => Up
        case ')' => Down
      })
  }
}
