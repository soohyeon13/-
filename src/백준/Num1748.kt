package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    var index = 1
    var temp = 0
    var len = 10
    for (i in 1 .. n) {
        if (i == len) {
            index++
            len *= 10
        }
        temp += index
    }
    println(temp)
    bw.flush()
}