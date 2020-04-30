package 백준

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var burger = 2001
    var drink = 2001
    for (i in 0 until 3) {
        val a = br.readLine().toInt()
        if (a < burger) {
            burger =a
        }
    }
    for (i in 0 until 2) {
        val a = br.readLine().toInt()
        if (a < drink) {
            drink = a
        }
    }
    val answer = burger + drink -50
    println(answer)
    bw.flush()
}