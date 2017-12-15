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

class Day12Spec : StringSpec() {
  init {
    """0 <-> 2
       1 <-> 1
       2 <-> 0
    """ {
      parsePipes("0 <-> 2\n1 <-> 1\n2 <-> 0") shouldBe
          mapOf("0" to listOf("2"), "1" to listOf("1"), "2" to listOf("0"))
    }

    """0 <-> 2
       1 <-> 1
       2 <-> 0, 3, 4
       3 <-> 2, 4
       4 <-> 2, 3, 6
       5 <-> 6
       6 <-> 4, 5
    """ {
      countPipes("0 <-> 2\n1 <-> 1\n2 <-> 0, 3, 4\n3 <-> 2, 4\n4 <-> 2, 3, 6\n5 <-> 6\n6 <-> 4, 5") shouldBe 6

    }

    "Day 12.1 answer is ..." {
      val file = File("/Users/rob/Development/source/github/advent-of-code-2017/src/test/kotlin/Day12Data.txt")
      val answer = countPipesFile(file)

      answer shouldBe 113

      println("Day 12.1 answer = $answer")
    }

    """Contains 2 groups:
       0 <-> 2
       1 <-> 1
       2 <-> 0, 3, 4
       3 <-> 2, 4
       4 <-> 2, 3, 6
       5 <-> 6
       6 <-> 4, 5
    """ {
      countGroups("0 <-> 2\n1 <-> 1\n2 <-> 0, 3, 4\n3 <-> 2, 4\n4 <-> 2, 3, 6\n5 <-> 6\n6 <-> 4, 5") shouldBe 2
    }

    "Day 12.2 answer is ..." {
      val file = File("/Users/rob/Development/source/github/advent-of-code-2017/src/test/kotlin/Day12Data.txt")
      val answer = countGroupsFile(file)

      answer shouldBe 202

      println("Day 12.2 answer = $answer")
    }

  }

}
