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

// Requested data must be carried back to square 1 (the location of the only access port for this memory system)
// by programs that can only move up, down, left, or right.
//
// They always take the shortest path: the Manhattan Distance between the location of the data and square 1.
import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import kotlin.math.ceil
import kotlin.math.round

class Day3Spec : StringSpec() {
  init {

    "Data from square 1 is carried 0 steps, since it's at the access port." {
      manhattanDistance(Pair(0,0), navigateSpiral(1)) shouldBe 0
    }

    "Data from square 12 is carried 3 steps, such as: down, left, left." {
      manhattanDistance(Pair(0,0), navigateSpiral(12)) shouldBe 3
    }

    "Data from square 23 is carried only 2 steps: up twice." {
      manhattanDistance(Pair(0,0), navigateSpiral(23)) shouldBe 2
    }

    "Data from square 1024 must be carried 31 steps." {
      manhattanDistance(Pair(0,0), navigateSpiral(1024)) shouldBe 31
    }

    "Taxicab distance (0, 0) to (3, 3) is 9." {
      manhattanDistance(Pair(0, 0), Pair(3, 3)) shouldBe 6
    }

//    17  16  15  14  13
//    18   5   4   3  12
//    19   6   1   2  11
//    20   7   8   9  10
//    21  22  23---> ...

    "2 is at (1, 0) when navigating the spiral" {
      navigateSpiral(2) shouldBe Pair(1, 0)
    }

    "3 is at (1, 1) when navigating the spiral" {
      navigateSpiral(3) shouldBe Pair(1, 1)
    }

    "5 is at (-1, -1) when navigating the spiral" {
      navigateSpiral(5) shouldBe Pair(-1, 1)
    }

    "7 is at (-1, -1) when navigating the spiral" {
      navigateSpiral(7) shouldBe Pair(-1, -1)
    }

    "10 is at (2, -1) when navigating the spiral" {
      navigateSpiral(10) shouldBe Pair(2, -1)
    }

    "12 is at (2, 1) when navigating the spiral" {
      navigateSpiral(12) shouldBe Pair(2, 1)
    }

    "12 is at (2, 1) when navigating the spiral" {
      navigateSpiral(12) shouldBe Pair(2, 1)
    }

    "22 is at (-1, -2) when navigating the spiral" {
      navigateSpiral(22) shouldBe Pair(-1, -2)
    }

    "19 is at (-2, 0) when navigating the spiral" {
      navigateSpiral(19) shouldBe Pair(-2, 0)
    }

    "26 is at (3, -2) when navigating the spiral" {
      navigateSpiral(26) shouldBe Pair(3, -2)
    }

    "4 is at (0, 1) when navigating the spiral" {
      navigateSpiral(4) shouldBe Pair(0, 1)
    }

    "nextMove" {
      nextMove(::right) shouldBe ::up
      nextMove(::up) shouldBe ::left
      nextMove(::left) shouldBe ::down
      nextMove(::down) shouldBe ::right
    }

    "roundUp" {
      ceil(1.0/2.0) shouldBe 1.0
      ceil(2.0/2.0) shouldBe 1.0
      ceil(3.0/2.0) shouldBe 2.0
      ceil(4.0/2.0) shouldBe 2.0
      ceil(5.0/2.0) shouldBe 3.0
      ceil(6.0/2.0) shouldBe 3.0
    }

    "Day 3.1 answer is..." {
      val data = 361527
      val answer = manhattanDistance(Pair(0,0), navigateSpiral(data))

      println("Day 3.1 answer = $answer")
      answer shouldBe 326
    }
  }
}
