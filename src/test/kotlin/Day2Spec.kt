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

class Day2Spec : StringSpec() {
  init {

    // The spreadsheet consists of rows of apparently-random numbers.
    //
    // To make sure the recovery process is on the right track, they need you to calculate the
    // spreadsheet's checksum. For each row, determine the difference between the largest value
    // and the smallest value; the checksum is the sum of all of these differences.

    "[5 1 9 5] has checksum 8" {
      checksum("5\t1\t9\t5") shouldBe 8
    }

    """
    5 1 9 5
    7 5 3
    2 4 6 8
    has a checksum of 18
    """ {
      val data = "5\t1\t9\t5\n" + "7\t5\t3\n" + "2\t4\t6\t8"

      processSpreadsheet(data) shouldBe 18
    }

    "Day 2.1's answer is..." {
      val data = "86\t440\t233\t83\t393\t420\t228\t491\t159\t13\t110\t135\t97\t238\t92\t396\n" +
          "3646\t3952\t3430\t145\t1574\t2722\t3565\t125\t3303\t843\t152\t1095\t3805\t134\t3873\t3024\n" +
          "2150\t257\t237\t2155\t1115\t150\t502\t255\t1531\t894\t2309\t1982\t2418\t206\t307\t2370\n" +
          "1224\t343\t1039\t126\t1221\t937\t136\t1185\t1194\t1312\t1217\t929\t124\t1394\t1337\t168\n" +
          "1695\t2288\t224\t2667\t2483\t3528\t809\t263\t2364\t514\t3457\t3180\t2916\t239\t212\t3017\n" +
          "827\t3521\t127\t92\t2328\t3315\t1179\t3240\t695\t3144\t3139\t533\t132\t82\t108\t854\n" +
          "1522\t2136\t1252\t1049\t207\t2821\t2484\t413\t2166\t1779\t162\t2154\t158\t2811\t164\t2632\n" +
          "95\t579\t1586\t1700\t79\t1745\t1105\t89\t1896\t798\t1511\t1308\t1674\t701\t60\t2066\n" +
          "1210\t325\t98\t56\t1486\t1668\t64\t1601\t1934\t1384\t69\t1725\t992\t619\t84\t167\n" +
          "4620\t2358\t2195\t4312\t168\t1606\t4050\t102\t2502\t138\t135\t4175\t1477\t2277\t2226\t1286\n" +
          "5912\t6261\t3393\t431\t6285\t3636\t4836\t180\t6158\t6270\t209\t3662\t5545\t204\t6131\t230\n" +
          "170\t2056\t2123\t2220\t2275\t139\t461\t810\t1429\t124\t1470\t2085\t141\t1533\t1831\t518\n" +
          "193\t281\t2976\t3009\t626\t152\t1750\t1185\t3332\t715\t1861\t186\t1768\t3396\t201\t3225\n" +
          "492\t1179\t154\t1497\t819\t2809\t2200\t2324\t157\t2688\t1518\t168\t2767\t2369\t2583\t173\n" +
          "286\t2076\t243\t939\t399\t451\t231\t2187\t2295\t453\t1206\t2468\t2183\t230\t714\t681\n" +
          "3111\t2857\t2312\t3230\t149\t3082\t408\t1148\t2428\t134\t147\t620\t128\t157\t492\t2879"
      val answer = processSpreadsheet(data)

      println("Day 2.1 answer = $answer")
    }


    // It sounds like the goal is to find the only two numbers in each row where one evenly divides
    // the other - that is, where the result of the division operation is a whole number.
    //
    // They would like you to find those numbers on each line, divide them, and add up each line's result.

    "Pair that divides in [5 9 2 8] is 2 and 8" {
      pairThatDivides(listOf(2, 5, 8, 9)) shouldBe Pair(2, 8)
    }

    "[5 9 2 8] has checksum 4" {
      checksum2("5\t9\t2\t8") shouldBe 4
    }

    "[9 4 7 3] has checksum 3" {
      checksum2("9\t4\t7\t3") shouldBe 3
    }

    "[3 8 6 5] has checksum 2" {
      checksum2("3\t8\t6\t5") shouldBe 2
    }

    """
    5 9 2 8
    9 4 7 3
    3 8 6 5
    has a checksum of 9
    """ {
      val data = "5\t9\t2\t8\n" +
          "9\t4\t7\t3\n" +
          "3\t8\t6\t5"

     processSpreadsheet2(data) shouldBe 9
    }

    "Day 2.2's answer is..." {
      val data = "86\t440\t233\t83\t393\t420\t228\t491\t159\t13\t110\t135\t97\t238\t92\t396\n" +
          "3646\t3952\t3430\t145\t1574\t2722\t3565\t125\t3303\t843\t152\t1095\t3805\t134\t3873\t3024\n" +
          "2150\t257\t237\t2155\t1115\t150\t502\t255\t1531\t894\t2309\t1982\t2418\t206\t307\t2370\n" +
          "1224\t343\t1039\t126\t1221\t937\t136\t1185\t1194\t1312\t1217\t929\t124\t1394\t1337\t168\n" +
          "1695\t2288\t224\t2667\t2483\t3528\t809\t263\t2364\t514\t3457\t3180\t2916\t239\t212\t3017\n" +
          "827\t3521\t127\t92\t2328\t3315\t1179\t3240\t695\t3144\t3139\t533\t132\t82\t108\t854\n" +
          "1522\t2136\t1252\t1049\t207\t2821\t2484\t413\t2166\t1779\t162\t2154\t158\t2811\t164\t2632\n" +
          "95\t579\t1586\t1700\t79\t1745\t1105\t89\t1896\t798\t1511\t1308\t1674\t701\t60\t2066\n" +
          "1210\t325\t98\t56\t1486\t1668\t64\t1601\t1934\t1384\t69\t1725\t992\t619\t84\t167\n" +
          "4620\t2358\t2195\t4312\t168\t1606\t4050\t102\t2502\t138\t135\t4175\t1477\t2277\t2226\t1286\n" +
          "5912\t6261\t3393\t431\t6285\t3636\t4836\t180\t6158\t6270\t209\t3662\t5545\t204\t6131\t230\n" +
          "170\t2056\t2123\t2220\t2275\t139\t461\t810\t1429\t124\t1470\t2085\t141\t1533\t1831\t518\n" +
          "193\t281\t2976\t3009\t626\t152\t1750\t1185\t3332\t715\t1861\t186\t1768\t3396\t201\t3225\n" +
          "492\t1179\t154\t1497\t819\t2809\t2200\t2324\t157\t2688\t1518\t168\t2767\t2369\t2583\t173\n" +
          "286\t2076\t243\t939\t399\t451\t231\t2187\t2295\t453\t1206\t2468\t2183\t230\t714\t681\n" +
          "3111\t2857\t2312\t3230\t149\t3082\t408\t1148\t2428\t134\t147\t620\t128\t157\t492\t2879"
      val answer = processSpreadsheet2(data)

      println("Day 2.2 answer = $answer")
    }

  }
}
