package 백준

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    var a = Array(n+1){0}
    for (i in 1..n) {
        a[i] = arr[i-1]
    }
    val DP = Array(1001){0}
    var max = 0
    for(i in 1 ..  n) {
        var min = 0
        for(j in 0 until i) {
            if (a[i]> a[j]) {
                if (min <DP[j]){
                    min = DP[j]
                }
            }
        }
        DP[i] = min +1
        if (max < DP[i]) {
            max = DP[i]
        }
    }
    println(max)
    bw.flush()
}