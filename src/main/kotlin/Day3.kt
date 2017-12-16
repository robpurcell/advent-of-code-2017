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
import java.lang.Math.abs
import kotlin.math.ceil

fun manhattanDistance(p: Pair<Int, Int>, q: Pair<Int, Int>): Int {
  return abs(p.first - q.first) + abs(p.second - q.second)
}

fun navigateSpiral(number: Int): Pair<Int, Int> {
  assert(number >= 1)

  var index = 1
  var coords = Pair(0, 0)
  var count = 1
  var currentMove: () -> Pair<Int, Int> = ::right

  while (count < number) {
    if (count + changeIncrement(index) <= number) {
      val increment = changeIncrement(index)
      coords = move(coords, currentMove, increment)
      currentMove = nextMove(currentMove)
      count += increment
      index += 1
    }
    else {
      return move(coords, currentMove, number - count)
    }
  }

  return coords
}

fun move(coords: Pair<Int, Int>, direction: () -> Pair<Int, Int>, stepsToMove: Int): Pair<Int, Int> {
  return add(coords, scale(direction(), stepsToMove))
}

fun right(): Pair<Int, Int> {
  return Pair(1, 0)
}

fun up(): Pair<Int, Int> {
  return Pair(0, 1)
}

fun left(): Pair<Int, Int> {
  return Pair(-1, 0)
}

fun down(): Pair<Int, Int> {
  return Pair(0, -1)
}

fun nextMove(currentMove: () -> Pair<Int, Int>): () -> Pair<Int, Int> {
  val moves = arrayListOf<() -> Pair<Int, Int>>(::right, ::up, ::left, ::down)
  val currentMoveIndex = moves.indexOf(currentMove)
  val nextMoveIndex = (currentMoveIndex + 1) % 4
  return moves[nextMoveIndex]
}

private fun add(a: Pair<Int, Int>, b: Pair<Int, Int>): Pair<Int, Int> {
  return Pair(a.first + b.first, a.second + b.second)
}

private fun scale(a: Pair<Int, Int>, b: Int): Pair<Int, Int> {
  return Pair(a.first * b, a.second * b)
}

fun changeIncrement(count: Int): Int {
  return ceil(count / 2.0).toInt()
}
