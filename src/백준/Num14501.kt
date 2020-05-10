package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val t = IntArray(n+10)
    val p = IntArray(n+10)
    val dp = IntArray(n+10)
    var max = 0
    for (i in 1 .. n) {
        val (T,P) = br.readLine().split(" ").map { it.toInt() }
        t[i] = T
        p[i] = P
    }
    for (i in 1 .. n+1) {
        dp[i] = Math.max(dp[i],max)
        dp[t[i]+i] = Math.max(dp[t[i]+i],p[i]+dp[i])
        max = Math.max(max,dp[i])
    }
    println(max)
    bw.flush()
}