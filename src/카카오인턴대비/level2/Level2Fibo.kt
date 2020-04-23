package 카카오인턴대비.level2

class Level2Fibo {
    fun solution(n: Int) : Int {
        val DP = Array(100001){0}
        DP[1] = 1
        DP[2] = 1
        if (n >2) {
            for (i in 3.. n ) {
                DP[i] = DP[i-2] + DP[i-1]
            }
        }
        return DP[n] % 1234567
    }
}