package 백준

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (a,b,c) = br.readLine().split(" ").map { it.toLong() }
    if (b >= c) println(-1)
    else {
        val d = c-b
        println(a/d + 1)
    }
    bw.flush()
}