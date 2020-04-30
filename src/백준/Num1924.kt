package 백준

private val day = arrayOf("SUN","MON","TUE","WED","THU","FRI","SAT")
private val month = intArrayOf(31,28,31,30,31,30,31,31,30,31,30,31)
fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val date = br.readLine().split(" ").map { it.toInt() }
    var dayCnt = 0
    for (i in 0 until date[0]-1) {
        dayCnt += month[i]
    }
    dayCnt += date[1]
    println(day[dayCnt%7])
    bw.flush()
}