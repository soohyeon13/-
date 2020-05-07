package 백준

import kotlin.math.min

private lateinit var map: Array<LongArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val v = n[0]
    val edge = n[1]
    map = Array(v + 1) { LongArray(v + 1) { 0 } }
    for (i in 1..v) {
        for (j in 1.. v) {
            if (i !=j ) map[i][j] = 2000000000
        }
    }
    for (i in 0 until edge) {
        val row = br.readLine().split(" ").map { it.toInt() }
        map[row[0]][row[1]] = min(map[row[0]][row[1]], row[2].toLong())
        map[row[1]][row[0]] = map[row[0]][row[1]]
    }
    for (k in 1..v) {
        for(i in 1..v) {
            for (j in 1..v) {
                map[i][j] = min(map[i][j] , map[i][k] + map[k][j])
            }
        }
    }
    val destination = br.readLine().split(" ").map { it.toInt() }
    val answer =
            min(map[1][destination[0]] + map[destination[0]][destination[1]] + map[destination[1]][v],
            map[1][destination[1]] + map[destination[1]][destination[0]] + map[destination[0]][v])
    if (answer > 2000000000 ) println(-1)
    else println(answer)
    bw.flush()
}