package 백준

private val arr = intArrayOf(500,100,50,10,5,1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val pay = br.readLine().toInt()
    var change = 1000 - pay
    var answer = 0
    for (i in arr.indices) {
        answer += change/arr[i]
        change %= arr[i]
        if (change == 0) break
    }
    println(answer)
    bw.flush()
}