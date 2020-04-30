package 백준

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map{it.toInt()}
    val arr = br.readLine().split(" ").map { it.toInt() }
    val answer = StringBuilder()
    for (i in arr.indices) {
        if (arr[i] <n[1]) answer.append("${arr[i]} ")
    }
    println(answer.trim().toString())
    bw.flush()
}