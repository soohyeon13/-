package skillcheck3

class Solution2 {
    fun solution(stones:IntArray,k:Int):Int {
        var left : Long= 0
        var right : Long= 200000000
        var answer : Long= 0
        while (left <= right) {
            val mid = (left+ right)/2
            var count = 0
            for (i in stones.indices) {
                if (count >=k) break
                if (mid>stones[i]) {
                    count+=1
                }else {
                    count = 0
                }
            }
            if (count >= k) {
                right = mid-1
            }else {
                left = mid +1
                answer = if (mid> answer) mid else answer
            }
            println("left : $left right :$right")
        }
        return answer.toInt()
    }
}