package 카카오인턴2020

import java.util.*

class Solution3 {
    fun solution(gems: Array<String>): IntArray {
        val arr = gems.distinct()
        var left = 1
        var right = gems.size
        val n = arr.size
        var sol = Int.MAX_VALUE
        var start = 100000
        var mid = 0
        while (left <= right) {
            mid = (left + right) / 2
            var cnt = 0
            for (i in 0..gems.size - mid) {
                val map = HashMap<String, Int>()
                cnt = 0
                for (j in i until i + mid) {
                    if (!map.containsKey(gems[j])) {
                        cnt += 1
                        map[gems[j]] = 1
                    }
                }
                if (cnt >= n) {
                    start = i + 1
                    break
                }
            }
            if (cnt >= n) {
                right = mid - 1
                sol = if (sol > mid) mid else sol
            } else if (cnt < n) {
                left = mid + 1
            }
        }
        return intArrayOf(start, start + sol - 1)
    }
}