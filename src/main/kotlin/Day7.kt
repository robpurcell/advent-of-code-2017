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

interface Program {
  val name: String
}

data class ActualProgram(override val name: String, val weight: Int) : Program

data class ProgramReference(override val name: String) : Program

fun parseProgramDefinition(input: String): ActualProgram {
  val name = input.split(" ").first()

  val weightTemplate = Regex("(\\d+)")
  val weight = weightTemplate.find(input)?.value?.toInt()

  if (input.contains("->")) {
    val refNames = input.split("->").last().trimStart().split(" ")
    val programRefs = refNames.map { r -> ProgramReference(r.split(",").first()) }
  }

  return ActualProgram(name, weight!!)
}

//fun calculateTreeRoot(programs: List<Program>): String {
//  var tree: Program
//
//  for (p in programs) {
//    tree =
//  }
//
//  return program.name
//}

interface Node {
  val program: Program
}

class Leaf(override val program: Program) : Node

class Branch(override val program: Program, nodes: List<Node>) : Node


