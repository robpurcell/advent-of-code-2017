import io.kotlintest.matchers.shouldBe
import io.kotlintest.specs.StringSpec
import javax.imageio.spi.RegisterableService

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

class Day8Spec : StringSpec() {
  init {
    "b inc 5 if a > 1" {
      val cpu = Cpu()
      cpu.processRegisterInstruction("b inc 5 if a > 1").get("b") shouldBe 0
    }
    "a inc 1 if b < 5" {
      val cpu = Cpu()
      cpu.processRegisterInstruction("a inc 1 if b < 5").get("a") shouldBe 1
    }
    "a inc 1 if b < 5, c dec -10 if a >= 1" {
      val cpu = Cpu()
      cpu.processRegisterInstruction("a inc 1 if b < 5").get("a") shouldBe 1
      cpu.processRegisterInstruction("c dec -10 if a >= 1").get("c") shouldBe 10
    }



  }

}
