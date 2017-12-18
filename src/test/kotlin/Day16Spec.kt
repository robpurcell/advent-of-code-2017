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

class Day16Spec : StringSpec() {
  init {
    "s1 abcde" {
      spin(1, "abcde") shouldBe "eabcd"
    }

    "s3 on abcde produces cdeab" {
      spin(3, "abcde") shouldBe "cdeab"
    }

    "x3/4, eabcd swapping the last two programs: eabdc" {
      swap(3, 4, "eabcd") shouldBe "eabdc"
    }

    "pe/b, eabdc swapping programs e and b: baedc." {
      partner("e", "b", "eabdc") shouldBe "baedc"
    }

    "Day 16.1 answer is ..." {
      val file = File("/Users/rob/Development/source/github/advent-of-code-2017/src/test/kotlin/Day16Data.txt")
      val programs = "abcdefghijklmnop"
      val answer = processProgramDanceFile(programs, file)

//      answer shouldBe 208

      println("Day 16.1 answer = $answer")
    }


  }
}
