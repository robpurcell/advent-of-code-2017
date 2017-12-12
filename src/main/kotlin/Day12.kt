import java.io.File

// Copyright 2017 Purcell Informatics Limited
//
// See the LICENCE file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

val pipeExpr = Regex("(\\w)*<->(\\w)*")

fun countPipes(input: String): Int {
  val pipes = parsePipes(input)

  val traversal = traverse("0", pipes).toSet()
  return traversal.size
}

private fun traverse(index: String, pipes: Map<String, List<String>>): List<String> {
  val linkedPipes = pipes.getOrDefault(index, listOf())
  return listOf(index) + (linkedPipes.flatMap { p -> traverseWip(p, pipes, listOf(index)) })
}

private fun traverseWip(index: String, pipes: Map<String, List<String>>, wip: List<String>): List<String> {
  val linkedPipes = pipes.getOrDefault(index, listOf()).filter { i -> !wip.contains(i) }
  return listOf(index) + (linkedPipes.flatMap { p -> traverseWip(p, pipes, wip + index) })
}

fun parsePipes(input: String): Map<String, List<String>> {
  val links = mutableMapOf<String, List<String>>()

  val lines = input.split("\n")
  for (l in lines) {
    val index = l.split(" ").first()
    val linkedPrograms = pipeExpr.split(l).last().trimStart().split(", ")

    links.put(index, linkedPrograms)
  }

  return links
}

fun countPipesFile(f: File): Int {
  return countPipes(f.readText())
}
