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
fun captcha(input: String): Int {
  var sum = 0

  for (i in 0..input.length - 2) {
    val (a, b) = Pair(intValue(input[i]), intValue(input[i + 1]))

    if (a == b) {
      sum += a
    }
  }

  if (input[0] == input[input.length - 1]) {
    sum += intValue(input[0])
  }

  return sum
}

private fun intValue(input: Char) = input.toInt() - 48
