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

fun spin(x: Int, programs: String): String {
  if (x == 0) {
    return programs
  }
  return spin(x - 1, spin1(programs))
}

fun spin1(programs: String): String {
  return programs.last() + programs.substring(0, programs.length - 1)
}

fun swap(a: Int, b: Int, programs: String): String {
  val swapped = programs.toCharArray().asList().toMutableList()
  swapped[a] = programs[b]
  swapped[b] = programs[a]

  return String(swapped.toCharArray())
}

fun partner(a: String, b: String, programs: String): String {
  val indexA = programs.indexOf(a)
  val indexB = programs.indexOf(b)

  return swap(indexA, indexB, programs)
}

fun processProgramDanceFile(programs: String, f: File): String {
  var result = ""
  f.forEachLine { l ->
    if (l != "") {
      result = processProgramDance(programs, l)
    }
  }

  return result
}

fun processProgramDance(programs: String, commands: String): String {
  for (c in commands.split(","))  {
    when(c.first()) {
      's' -> spin(c.substring(1).toInt(), programs)
      'p'-> partner(c[1].toString(), c[3].toString(), programs)
      'x' -> swap()
    }
  }
}
