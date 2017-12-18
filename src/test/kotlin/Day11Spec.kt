import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

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

class Day11Spec : StringSpec() {
  init {
    "n,s cancel" {
      removeCancellingMoves("n,s") shouldBe 0
    }

    "n,n,s is 1 step away" {
      removeCancellingMoves("n,n,s") shouldBe 1
    }

    "ne,ne,sw is 1 step away" {
      removeCancellingMoves("ne,ne,sw") shouldBe 1
    }

    "ne,ne,ne is 3 steps away" {
      removeCancellingMoves("ne,ne,ne") shouldBe 3
    }

    "se,se,se is 3 steps away" {
      removeCancellingMoves("se,se,se") shouldBe 3
    }

    "ne,ne,s,s is 2 steps away (se,se)" {
      removeCancellingMoves("ne,ne,s,s") shouldBe 2
    }

  }

}
