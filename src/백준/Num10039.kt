package 백준

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var totalScore = 0
    for (i in 0 until 5) {
        var scroe = br.readLine().toInt()
        if (scroe <40) {
            scroe = 40
        }
        totalScore += scroe
    }
    println(totalScore/5)
    bw.flush()
}