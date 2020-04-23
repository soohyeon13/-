package 카카오인턴대비.level2

class Level2CntDecimal {
    private var answer = 0
    fun solution(nums :IntArray):Int {
        for (i in 0 until nums.size-2) {
            for (j in i+1 until nums.size-1) {
                for (k in j+1 until nums.size) {
                    val num = nums[i] + nums[j] + nums[k]
                    checkDecimal(num)
                }
            }
        }
        return answer
    }
    private fun checkDecimal(num : Int) {
        if (num < 1) return
        else {
            for (i in 2 until num ) {
                if (num % i == 0 )return
            }
            answer++
        }
    }
}