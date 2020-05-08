package 백준

import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    var left : Long = 1
    var right : Long = k.toLong()
    var answer : Long= 0
    while (left <= right) {
        var cnt = 0
        val mid = (left + right)/2

        for (i in 1.. n) {
            cnt += min((mid/i).toInt(),n)
        }
        if (cnt >= k) {
            answer = mid
            right = mid-1
        }else {
            left = mid +1
        }
    }
    println(answer)
    bw.flush()
}