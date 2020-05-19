package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val map = br.readLine().split(" ").map { it.toInt() }
    val DP = Array(n){LongArray(21)}
    DP[0][map[0]] =1
    for (i in 1 until n-1) {
        for (j in 0..20) {
            if (DP[i-1][j] >0) {
                var num = j + map[i]
                if (num in 0..20) DP[i][num] += DP[i-1][j]
                num = j - map[i]
                if (num in 0..20) DP[i][num] += DP[i-1][j]
            }
        }
    }
    println(DP[n-2][map[n-1]])
    bw.flush()
}