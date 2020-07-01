package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    println(br.readLine().split(" ").filter { it != "" }.count())
}