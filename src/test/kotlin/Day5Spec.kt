import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
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

class Day5Spec : StringSpec() {
  init {
    "(0) 3  0  1  -3 is 5 jumps to escape" {
      countJumps("0\n3\n0\n1\n-3", ::standardIncrement) shouldBe 5
    }

    "Day 5.1 answer is ..." {
      val file = File("/Users/rob/Development/source/github/advent-of-code-2017/src/test/kotlin/Day5Data.txt")
      val answer = countJumpsInFile(file)

      answer shouldBe 378980

      println("Day 5.1 answer = $answer")
    }

    "Day 5.2 answer is ..." {
      val file = File("/Users/rob/Development/source/github/advent-of-code-2017/src/test/kotlin/Day5Data.txt")
      val answer = countJumpsInFileWithWierdOffset(file)

      answer shouldBe 26889114

      println("Day 5.2 answer = $answer")
    }

  }
}
