package 백준

import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var n = br.readLine().toInt()
    var map = Array(10){0}
    var div = 10
    var num = 0
    while (true) {
        if (n ==0) break
        num = n % div
        n /=div
        if (num == 6 || num == 9) {
            if (map[6] > map[9]) map[9] +=1
            else map[6] +=1
        }else map[num] +=1
    }
    val answer = map.max()
    if (answer == 0) {
        println(1)
    }else println(answer)
    bw.flush()
}