import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

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

class Day3Spec : StringSpec() {
  init {

    "Data from square 1 is carried 0 steps, since it's at the access port." {

    }


    "Data from square 12 is carried 3 steps, such as: down, left, left." {
    }

    "Data from square 23 is carried only 2 steps: up twice." {

    }
    "Data from square 1024 must be carried 31 steps." {

    }

    "Taxicab distance (0, 0) to (3, 3) is 9." {
      manhattanDistance(Pair(0, 0), Pair(3, 3)) shouldBe 6
    }

    "lastNumberInLoop test" {
      lastNumberInLoop(1) shouldBe 1
      lastNumberInLoop(2) shouldBe 9
      lastNumberInLoop(3) shouldBe 25
      lastNumberInLoop(4) shouldBe 49
    }

    "sizeOfLoop test" {
      sizeOfLoop(1) shouldBe 1
      sizeOfLoop(2) shouldBe 8
      sizeOfLoop(3) shouldBe 16
      sizeOfLoop(4) shouldBe 24
    }

    "firstNumberInLoop test" {
      firstNumberInLoop(2) shouldBe 2
      firstNumberInLoop(3) shouldBe 10
      firstNumberInLoop(4) shouldBe 26
      firstNumberInLoop(5) shouldBe 50
    }

    "coordinatesOfFirstNumberInLoop test" {
      coordinatesOfFirstNumberInLoop(1) shouldBe Pair(0, 0)
      coordinatesOfFirstNumberInLoop(2) shouldBe Pair(1, 0)
      coordinatesOfFirstNumberInLoop(3) shouldBe Pair(2, -1)
      coordinatesOfFirstNumberInLoop(4) shouldBe Pair(3, -2)
      coordinatesOfFirstNumberInLoop(5) shouldBe Pair(4, -3)
    }

    "findLoopNumber test" {
      findLoopNumber(3) shouldBe 2
      findLoopNumber(12) shouldBe 3
      findLoopNumber(27) shouldBe 4
    }

    "12 is at (2, 1)" {
      coordinates(12) shouldBe Pair(2, 1)
    }

  }
}
