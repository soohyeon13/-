package 백준

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val score = br.readLine().toInt()
    when(score) {
        in 90 .. 100 -> println("A")
        in 80 .. 89 -> println("B")
        in 70.. 79 -> println("C")
        in 60 .. 69 -> println("D")
        else -> println("F")
    }
    bw.flush()
}