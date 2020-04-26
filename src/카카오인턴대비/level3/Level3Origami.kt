package 카카오인턴대비.level3

class Level3Origami {
    fun solution(n: Int): IntArray {
        val DP = Array(21){""}
        DP[1] = "0"
        DP[2] = "001"
        if (n >=3) {
            for (i in 3 .. n) {
                val str = StringBuilder()
                str.append("${DP[i - 1]}0")
                for (j in DP[i-1].length-1 downTo 0) {
                    if (DP[i-1][j] == '1') str.append("0")
                    else str.append("1")
                }
                DP[i] = str.toString()
            }
        }
        val answer = Array(DP[n].length){0}
        for (i in 0 until DP[n].length) {
            answer[i] = DP[n][i].toString().toInt()
        }
        return answer.toIntArray()
    }
}