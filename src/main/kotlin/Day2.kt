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

fun checksum(row: String): Int {
  val numbersAsListOfString = row.split("\t")
  val numbers = numbersAsListOfString.map({n -> intValue(n)})
  val max = numbers.max()
  val min = numbers.min()

  val checksum = (max ?: 0) - (min ?: 0)
  println("Checksum = $checksum")

  return checksum
}

fun processSpreadsheet(input: String): Int {
  val rows = input.split("\n")
  return rows.sumBy { checksum(it) }
}

fun checksum2(row: String): Int {
  val numbersAsListOfString = row.split("\t")
  val numbers = numbersAsListOfString.map({n -> intValue(n)})
  val sortedNumbers = numbers.sorted()

  val (a, b) = pairThatDivides(sortedNumbers)
  val checksum = b / a

  println("Checksum = $checksum")

  return checksum
}

fun pairThatDivides(sortedNumbers: List<Int>): Pair<Int, Int> {
  for (i in 0 until sortedNumbers.size - 1) {
    val numbersToCheck = sortedNumbers.takeLast(sortedNumbers.size - (i + 1))
    for (j in 0 until numbersToCheck.size) {
      val (a, b) = Pair(sortedNumbers[i], numbersToCheck[j])
      if (b % a == 0) {
        println("Pair($a, $b)")
        return Pair(a, b)
      }
    }
  }
  return Pair(0, 0)
}

fun processSpreadsheet2(input: String): Int {
  val rows = input.split("\n")
  return rows.sumBy { checksum2(it) }
}
