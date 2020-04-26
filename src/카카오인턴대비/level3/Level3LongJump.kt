package 카카오인턴대비.level3

class Level3LongJump {
    fun solution(n: Int): Long {
        val DP = Array(2001) { 1.toLong() }
        DP[1] = 1
        DP[2] = 2
        if (n >= 3) {
            for (i in 3..n) {
                DP[i] = (DP[i - 1] + DP[i - 2]) % 1234567
            }
        }
        return DP[n]
    }
}