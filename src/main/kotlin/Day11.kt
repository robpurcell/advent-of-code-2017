import kotlin.math.abs

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

fun removeCancellingMoves(moves: String): Int {
  val moveList = moves.split(",")

  val n = calculateNorth(moveList)
  val ne = calculateNorthEast(moveList)
  val nw = calculateNorthWest(moveList)

  return 0
}

fun calculateNorth(moves: List<String>): String {
  val north = moves.count({ c -> c == "n" })
  val south = moves.count({ c -> c == "s" })
  val magnitude = north - south

  return when {
    magnitude > 0 -> "n,".repeat(magnitude)
    magnitude < 0 -> "s,".repeat(magnitude)
    else -> ""
  }

}

fun calculateNorthEast(moves: List<String>): String {
  val northEast = moves.count({ c -> c == "ne" })
  val southWest = moves.count({ c -> c == "sw" })
  val magnitude = northEast - southWest

  return when {
    magnitude > 0 -> "ne,".repeat(magnitude)
    magnitude < 0 -> "sw,".repeat(magnitude)
    else -> ""
  }

}

fun calculateNorthWest(moves: List<String>): String {
  val northWest = moves.count({ c -> c == "nw" })
  val southEast = moves.count({ c -> c == "se" })
  val magnitude =  northWest - southEast

  return when {
    magnitude > 0 -> "nw,".repeat(magnitude)
    magnitude < 0 -> "se,".repeat(magnitude)
    else -> ""
  }

}
