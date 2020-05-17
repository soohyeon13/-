package 백준

import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m,k) = br.readLine().split(" ").map { it.toInt() }
    var maxTeam = min(n/2,m)
    while (true) {
        val team = n+m -(maxTeam*3)
        if (k - team  <=0) break
        maxTeam -=1
    }
    println(maxTeam)
    bw.flush()
}