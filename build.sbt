val root = (project in file("."))
  .settings(
    name := "Advent of Code 2015",
    moduleName := "aoc-2015",
    scalaVersion := "2.13.7",
    run / fork := true,
    Test / parallelExecution := false
  )
  .withDependencies
