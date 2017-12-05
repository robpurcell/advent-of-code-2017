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

fun countJumps(message: String, decider: (Int) -> Int): Int {
  var index = 0
  var jumpCounter = 0

  val messageArray = message.trimEnd().split("\n").toMutableList()

  while (index >= 0 && index < messageArray.size) {
    val currentValue = messageArray[index]

    val newValue = currentValue.toInt() + decider(currentValue.toInt())
    messageArray[index] = newValue.toString()
//    println(messageArray)
    index += currentValue.toInt()
    jumpCounter++
  }

  return jumpCounter
}

fun decideIncrement(i: Int): Int {
  return if (i >= 3) -1
  else {
    1
  }
}

fun standardIncrement(i: Int): Int {
  return 1
}

fun countJumpsInFile(f: File): Int {
  return countJumps(f.readText(), ::standardIncrement)
}

fun countJumpsInFileWithWierdOffset(f: File): Int {
  return countJumps(f.readText(), ::decideIncrement)
}
