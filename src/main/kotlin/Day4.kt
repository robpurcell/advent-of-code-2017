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
  val validWords = mutableListOf<String>()

  val words = pass.split(" ")

  for (w in words) {
    if (validWords.contains(w)) {
      return false
    }
    else {
      validWords.add(w)
    }
  }
  return true
}

fun countValidPhrases(f: File): Int {
  var count = 0

  f.forEachLine { l ->

    if (!l.equals("") && isValidPass(l)) count += 1
  }

  return count
}
