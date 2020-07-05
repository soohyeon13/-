package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val (start, end) = br.readLine().split("*")
    val regex = """$start(\w*)$end""".toRegex()
    for (i in 0 until n) {
        val word = br.readLine()
        if (regex.matches(word)) println("DA")
        else println("NE")
    }
    bw.flush()
}