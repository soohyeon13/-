package 백준

import kotlin.collections.ArrayList
import kotlin.math.max

private lateinit var map : Array<ArrayList<Bridge>>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(" ").map {it.toInt()}
    map = Array(n+1){ArrayList<Bridge>()}
    var left = 1.toLong()
    var right = 0.toLong()
    for (i in 1 .. m) {
        val (a,b,c) = br.readLine().split(" ")
        map[a.toInt()].add(Bridge(b.toInt(),c.toLong()))
        map[b.toInt()].add(Bridge(a.toInt(),c.toLong()))
        right = max(right,c.toLong())
    }
    val (start, end) = br.readLine().split(" ").map { it.toInt() }
    var answer : Long= 0
    while (left<=right) {
        val mid = (left + right)/2
        val visited = BooleanArray(n+1)
        if (dfs(map,mid,start,end,visited)) {
            left = mid +1
            answer = max(answer,mid)
        }else {
            right = mid-1
        }
    }
    println(answer)
    bw.flush()
}

private fun dfs(arr : Array<ArrayList<Bridge>>,mid : Long,start: Int, end: Int, visited : BooleanArray) : Boolean {
    if(visited[start]) return false
    visited[start] = true
    if (start == end) return true
    for (element in arr[start]) {
        if (element.cost >=mid) {
            if (dfs(arr,mid,element.end, end,visited)) return true
        }
    }
    return false
}
private data class Bridge(
        val end : Int,
        val cost : Long
)