package 데브매칭2020

import java.util.*
import kotlin.collections.HashMap

class Solution4 {
    fun solution(votes: Array<String>, k: Int): String {
        val map = HashMap<String, Int>()
        for (i in votes.indices) {
            if (!map.containsKey(votes[i])) {
                map[votes[i]] = 1
            } else {
                map[votes[i]] = map[votes[i]]!! + 1
            }
        }

        val sortList = map
                .toList()
                .sortedWith(Comparator { t: Pair<String, Int>, t2: Pair<String, Int> ->
                    if (t.second > t2.second) 1
                    else if (t.second == t2.second) {
                        if (t.first > t2.first) -1
                        else 1
                    } else -1
                })
        var sum = 0
        for (i in 0 until k) {
            sum += sortList[sortList.size - 1 - i].second
        }
        var answer = 0
        var result = ""
        for (i in sortList.indices) {
            answer += sortList[i].second
            if (answer >= sum) break
            result = sortList[i].first
        }
        println(result)
        return result
    }
}

fun main() {
    val sol = Solution4()
    val arr = arrayOf("AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA")
    val arr2 = arrayOf("AAD", "AAA", "AAC", "AAB")
    sol.solution(arr, 2)
}