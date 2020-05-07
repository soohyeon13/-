package 백준

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

private lateinit var map : Array<ArrayList<Specific>>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt()}
    val v = n[0]
    val edge = n[1]
    map = Array(v+1){ ArrayList<Specific>() }
    for (i in 0 until edge) {
        val row = br.readLine().split(" ").map { it.toInt() }
        map[row[0]].add(Specific(row[1],row[2]))
        map[row[1]].add(Specific(row[0],row[2]))
    }
    var answer = 0
    val destination = br.readLine().split(" ").map { it.toInt() }
    answer += dfs(1, destination[0],v)
    answer += dfs(destination[0], destination[1],v)
    answer += dfs(destination[1],v,v)
    var answer2 = 0
    answer2 += dfs(1, destination[1],v)
    answer2 += dfs(destination[1], destination[0],v)
    answer2 += dfs(destination[0],v,v)
    if (answer >= 200000000 && answer2 >= 200000000) println(-1)
    else println(min(answer,answer2))
    bw.flush()
}
private fun dfs(start:Int,end : Int,v: Int) : Int {
    val queue : Queue<Specific> = LinkedList()
    val copyDist = Array(v +1){Int.MAX_VALUE}
    queue.add(Specific(start,0))
    copyDist[start] = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (element in map[q.end]) {
            if (copyDist[element.end] > copyDist[q.end] + element.cost) {
                copyDist[element.end] = copyDist[q.end] +element.cost
                queue.add(Specific(element.end, copyDist[element.end]))
            }
        }
    }
    return copyDist[end]
}

private data class Specific(
        val end : Int,
        val cost : Int
)