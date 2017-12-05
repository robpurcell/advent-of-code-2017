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

fun isValidPass(pass: String): Boolean {
  return validatePass(pass, ::contains)
}

fun isValidPassNoAnagrams(pass: String): Boolean {
  return validatePass(pass, ::containsAnagram)
}

fun validatePass(pass: String, comparison: (List<String>, String) -> Boolean): Boolean {
  val validWords = mutableListOf<String>()

  val words = pass.split(" ")

  for (w in words) {
    if (comparison(validWords, w)) {
      return false
    }
    else {
      validWords.add(w)
    }
  }
  return true
}

fun countValidPhrasesBase(f: File, validation: (String) -> Boolean): Int {
  var count = 0

  f.forEachLine { l ->
    if (l != "" && validation(l)) count += 1
  }

  return count
}

fun countValidPhrases(f: File): Int {
  return countValidPhrasesBase(f, ::isValidPass)
}

fun countValidPhrasesNoAnagram(f: File): Int {
  return countValidPhrasesBase(f, ::isValidPassNoAnagrams)
}

fun contains(words: List<String>, word: String): Boolean {
  return words.contains(word)
}

fun containsAnagram(words: List<String>, inputWord: String): Boolean {
  val sortedInputWord = inputWord.toList().sorted()
  for (w in words) {
    val sortedW = w.toList().sorted()

    if (sortedW == sortedInputWord)
      return true
  }
  return false
}
