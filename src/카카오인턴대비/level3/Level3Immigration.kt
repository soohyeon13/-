package 카카오인턴대비.level3

class Level3Immigration {
    fun solution(n: Int, times: IntArray) : Long {
        var left : Long= 1
        val max = times.max()!!.toLong()
        var right : Long = max*n
        var answer : Long= Long.MAX_VALUE
        while (left <= right) {
            val mid: Long = (left+right)/2
            var cnt : Long = 0
            for (i in times.indices) {
                cnt += mid/times[i]
            }
            if (cnt >= n) {
                right = mid-1
                answer = Math.min(answer,mid)
            }else {
                left = mid+1
            }
        }
        return answer
    }
}