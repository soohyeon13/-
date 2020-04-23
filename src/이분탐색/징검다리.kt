package 이분탐색

class 징검다리 {
    fun solution(distance: Int, rocks:IntArray,n:Int):Int {
        rocks.sort()
        var answer :Long= 0
        var left : Long= 1
        var right:Long = distance.toLong()
        var mid : Long= 0
        while (left <= right) {
            var cnt = 0
            var prev = 0
            mid = (left+right)/2
            for (i in rocks.indices) {
                if (rocks[i]-prev < mid) {
                    cnt+=1

                }else {
                    prev = rocks[i]
                }
            }
            if (distance-prev < mid) cnt+=1
            if (cnt<=n) {
                answer = if (mid > answer) mid else answer
                left = mid +1
            }else{
                right = mid -1
            }

        }
        return answer.toInt()
    }
}