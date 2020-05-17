package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    println("${(a + b) % c}")
    println("${((a % c) + (b % c)) % c}")
    println("${(a * b) % c}")
    println("${((a % c) * (b % c)) % c}")
    bw.flush()
}