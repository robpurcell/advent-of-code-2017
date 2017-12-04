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

import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import java.io.File

class Day4Spec : StringSpec() {
  init {
    // A passphrase consists of a series of words (lowercase letters) separated by spaces.
    //
    // To ensure security, a valid passphrase must contain no duplicate words.

    "aa bb cc dd ee is valid." {
      isValidPass("aa bb cc dd ee") shouldBe true
    }

    "aa bb cc dd aa is not valid - the word aa appears more than once." {
      isValidPass("aa bb cc dd aa") shouldBe false
    }

    "aa bb cc dd aaa is valid - aa and aaa count as different words." {
      isValidPass("aa bb cc dd aaa") shouldBe true
    }

    "Small file contains 2 valid passphrases" {
      val file = File("/Users/rob/Development/source/github/advent-of-code-2017/src/test/kotlin/Day4SmallFile.txt")
      countValidPhrases(file) shouldBe 2
    }

    "Day 4.1 answer is ..." {
      val file = File("/Users/rob/Development/source/github/advent-of-code-2017/src/test/kotlin/Day4Data.txt")
      val answer = countValidPhrases(file)

      answer shouldBe 386

      println("Day 4.1 answer = $answer")
    }

  }
}
