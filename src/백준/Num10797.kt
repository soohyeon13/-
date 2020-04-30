package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val carNum = br.readLine().toInt()
    val date = br.readLine().split(" ").map { it.toInt() }
    println(date.filter { it == carNum }.count())
    bw.flush()
}