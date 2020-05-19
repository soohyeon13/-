package 백준

import java.util.*
import kotlin.Comparator

private val pq : PriorityQueue<String> = PriorityQueue()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val  map = br.readLine().split(" ").toTypedArray()
        if (map[0] == "0") break
        val visited = BooleanArray(map[0].toInt()+1)
        comb(map,visited,1,map[0].toInt(), 6)
        while (!pq.isEmpty()) {
            println(pq.poll())
        }
        println()
    }
    bw.flush()
}
private fun comb(arr:Array<String>,visited : BooleanArray,start:Int,n : Int,r : Int) {
    if (r == 0) {
        val sb = StringBuilder()
        for (i in 1 until visited.size) {
            if (visited[i]) {
                sb.append(arr[i]).append(" ")
            }
        }
        pq.offer(sb.toString().trim())
        return
    }
    for (i in start .. n) {
        visited[i] = true
        comb(arr,visited,start+1,n,r-1)
        visited[i] = false
    }
}