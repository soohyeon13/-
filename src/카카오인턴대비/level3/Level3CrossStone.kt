package 카카오인턴대비.level3

class Level3CrossStone {
    fun solution(stones:IntArray,k:Int) : Int {
        var left = 1.toLong()
        var rigth = 200000000.toLong()
        var answer = Long.MAX_VALUE
        while (left<=rigth) {
            val mid = (left + rigth)/2
            var count = 0
            for (i in stones.indices) {
                if (mid - stones[i] <=0) count+=1
                else count =0
                if (count >= k) break
            }
            println("left: $left ,right : $rigth mid : $mid , count :$count")
            if (count >= k) {
                rigth = mid-1
                answer = if (answer > mid) mid else answer
            }else {
                left = mid +1
            }
        }
        return answer.toInt()
    }
}