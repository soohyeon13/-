package 백준

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val DP = IntArray(13)
    DP[0] = 1
    DP[1] =1
    if (n >1) {
        for(i in 2 .. n) {
            DP[i] = DP[i-1] * i
        }
    }
    println(DP[n])
    bw.flush()
}