import java.lang.Math.*

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

fun manhattanDistance(p: Pair<Int, Int>, q: Pair<Int, Int>): Int {
  return abs(p.first - q.first) + abs(p.second - q.second)
}

fun sizeOfLoop(i: Int): Int {
  return if (i == 1) 1
  else lastNumberInLoop(i) - lastNumberInLoop(i - 1)
}

fun lastNumberInLoop(loopNumber: Int): Int {
  return pow((2 * loopNumber - 1).toDouble(), 2.0).toInt()
}

fun firstNumberInLoop(loopNumber: Int): Int {
  return lastNumberInLoop(loopNumber - 1) + 1
}

fun coordinatesOfFirstNumberInLoop(loopNumber: Int): Pair<Int, Int> {
  return if (loopNumber == 1) Pair(0, 0)
  else Pair(loopNumber - 1, 2 - loopNumber)
}

fun coordinates(number: Int): Pair<Int, Int> {
  return Pair(0, 0)
}

fun findLoopNumber(i: Int): Int {
  var loopNumber = 0
  var counter = i
  while (counter > 1) {
    counter -= lastNumberInLoop(loopNumber)
    loopNumber += 1
  }

  return loopNumber
}
