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

val expr = Regex("(\\w)*if(\\w)*")

fun parseInstruction(registerInstruction: String): Instruction {
  val registerToModify = registerInstruction.split(" ")[0]
  val direction = registerInstruction.split(" ")[1]
  val amountToChange = registerInstruction.split(" ")[2].toInt()
  val condition = expr.split(registerInstruction).last().trimStart().split(" ").drop(0)

  return Instruction(registerToModify,
                     amountToChange,
                     direction,
                     condition)
}

class Instruction(val registerToModify: String,
                  val amountToChange: Int,
                  val direction: String,
                  val condition: List<String>)

class Cpu {
  private var registers: Map<String, Int> = emptyMap()
    get() = field

  fun processRegisterInstruction(registerInstruction: String): Map<String, Int> {
    val inx = parseInstruction(registerInstruction)
    val amountToChange = (if (inx.direction == "dec") -1 else 1) * inx.amountToChange
    val newValue = processCondition(registers.getOrDefault(inx.registerToModify, 0),
                                    amountToChange,
                                    inx.condition)

    return mapOf(Pair(inx.registerToModify, newValue))
  }

  fun processCondition(registerValue: Int,
                       amountToChange: Int,
                       condition: List<String>): Int {
    val (conditionRegister, operand, conditionalAmount) = condition

    val conditionalRegisterValue = registers.getOrDefault(conditionRegister, 0)

    return when (operand) {
      ">" -> if (conditionalRegisterValue > conditionalAmount.toInt()) return registerValue + amountToChange else 0
      "<" -> if (conditionalRegisterValue < conditionalAmount.toInt()) return registerValue + amountToChange else 0
      ">=" -> if (conditionalRegisterValue >= conditionalAmount.toInt()) return registerValue + amountToChange else 0
      "<=" -> if (conditionalRegisterValue <= conditionalAmount.toInt()) return registerValue + amountToChange else 0
      "==" -> if (conditionalRegisterValue == conditionalAmount.toInt()) return registerValue + amountToChange else 0
      "!=" -> if (conditionalRegisterValue != conditionalAmount.toInt()) return registerValue + amountToChange else 0
      else -> 0
    }
  }
}

