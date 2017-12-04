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

    // Now, a valid passphrase must contain no two words that are anagrams of each other -
    // that is, a passphrase is invalid if any word's letters can be rearranged to form any
    // other word in the passphrase.

    "abcde fghij is a valid passphrase." {
      isValidPassNoAnagrams("abcde fghij") shouldBe true
    }

    "abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word." {
      isValidPassNoAnagrams("abcde xyz ecdab") shouldBe false
    }

    "a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word." {
      isValidPassNoAnagrams("a ab abc abd abf abj") shouldBe true
    }

    "iiii oiii ooii oooi oooo is valid." {
      isValidPassNoAnagrams("iiii oiii ooii oooi oooo") shouldBe true
    }

    "oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word." {
      isValidPassNoAnagrams("oiii ioii iioi iiio") shouldBe false
    }

    "Day 4.2 answer is ..." {
      val file = File("/Users/rob/Development/source/github/advent-of-code-2017/src/test/kotlin/Day4Data.txt")
      val answer = countValidPhrasesNoAnagram(file)

      answer shouldBe 208

      println("Day 4.2 answer = $answer")
    }


    "abcd is an anagram of dcba" {
      containsAnagram(listOf("abcd"), "dcba") shouldBe true
    }

    "abcd is not an anagram of dcb" {
      containsAnagram(listOf("abcd"), "dcb") shouldBe false
    }

  }
}
