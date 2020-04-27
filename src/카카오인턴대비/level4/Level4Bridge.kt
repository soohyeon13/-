package 카카오인턴대비.level4


class Level4Bridge {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        rocks.sort()
        var left : Long = 0
        var right : Long = distance.toLong()
        var answer : Long = 0
        while (left<=right) {
            val mid = (left+right)/2
            var rockCount  = 0
            var prev = 0
            for (i in rocks.indices) {
                if (rocks[i] - prev < mid) rockCount +=1
                else prev = rocks[i]
            }
            if (distance - prev < mid) rockCount +=1
            if (rockCount <= n) {
                left = mid +1
                answer = if (mid > answer) mid else answer
            }else {
                right = mid-1
            }
        }
        return answer.toInt()
    }
}