package 카카오인턴대비.level2

import kotlin.math.min

class Level2HIndex {
    fun solution(citations:IntArray):Int {
        val arr = citations.sortedByDescending { it }
        println(arr.toString())
        var answer =0
        for (i in arr.indices) {
            if (arr[i] <= i) {
                answer = min(arr[i],i)
                break
            }
        }
        return answer
    }
}