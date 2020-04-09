package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().toInt()
    val DP = IntArray(cnt+1)
    val cardPrice = br.readLine().split(" ")
    for (i in 1 .. cnt) {
        for (j in 1..i ) {
            DP[i] = Math.max(DP[i],cardPrice[j-1].toInt() + DP[i-j])
        }
    }
    println(DP[cnt])
}