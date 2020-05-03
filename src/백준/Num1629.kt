package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val answer =( Math.pow(n[0].toDouble(),n[1].toDouble()).toLong() % n[2]).toInt()
    println(answer)
    bw.flush()
}