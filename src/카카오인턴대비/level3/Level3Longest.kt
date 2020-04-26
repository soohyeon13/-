package 카카오인턴대비.level3

class Level3Longest {
    fun solution(s: String): Int {
        val DP = Array(s.length) {BooleanArray(s.length)}
        for (i in s.indices) {
            DP[i][i] = true
            if (i< s.length-1 && (s[i] == s[i+1])) {
                DP[i][i +1] = true
            }
        }
        println(DP.contentDeepToString())
        var answer = 1
        for (i in 2 until s.length) {
            for (j in 0 until s.length - i) {
                println("i :$i j:$j")
                if (s[j] == s[j+i]) {
                    if (DP[j+1][j+i-1]){
                        answer =  i+1
                        DP[j][j+i] = true
                    }
                }
            }
        }
        return answer
    }
}