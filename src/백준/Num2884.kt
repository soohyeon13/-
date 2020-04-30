package 백준

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val time = br.readLine().split(" ").map { it.toInt() }
    var totalMinute = 0
    totalMinute = (time[0] * 60 ) + time[1]
    var hour = 0
    var minute = 0
    if (totalMinute < 45) {
        totalMinute += (60 *24)
        hour = (totalMinute - 45)/60
        minute =(totalMinute - 45) % 60
    }else {
        hour = (totalMinute - 45)/60
        minute = (totalMinute - 45) % 60
    }
    println("$hour $minute")
    bw.flush()
}