package 월간코테.두번째

import kotlin.math.max
import kotlin.math.min

private lateinit var arr : Array<ArrayList<Int>>
private lateinit var visited : BooleanArray
private var maxDepth = 0
private var vertex = 0
class Solution3 {
    fun solution(n: Int, edges: Array<IntArray>): Int {
        var answer: Int = 0
        arr = Array(n+1){ArrayList<Int>()}
        visited = BooleanArray(250010)
        val distOne = IntArray(250010)
        val distTwo = IntArray(250010)

        for (i in edges.indices) {
            arr[edges[i][0]].add(edges[i][1])
            arr[edges[i][1]].add(edges[i][0])
        }
        dfs(1,0)
        maxDepth = 0
        val a = vertex
        visited = BooleanArray(250010)
        dfs(vertex,0)
        val b = vertex

        secondDfs(1,a,distOne)
        secondDfs(1,b,distTwo)

        for (i in 1..n) {
            if (i ==a || i == b) {
                continue
            }
            answer = max(answer, min(maxDepth, max(distOne[i]-1 ,distTwo[i]-1)))
        }
        return answer
    }

    private fun dfs(start:Int,sum:Int){
        visited[start] = true
        if (sum > maxDepth) {
            maxDepth = sum
            vertex = start
        }
        for (i in arr[start].indices) {
            if (visited[arr[start][i]]) continue
            dfs(arr[start][i],sum+1)
        }
    }

    private fun secondDfs(dist : Int, start:Int, distArr:IntArray) {
        distArr[start] = dist
        for (i in arr[start].indices) {
            if (distArr[arr[start][i]] != 0) continue
            secondDfs(dist+1,arr[start][i],distArr)
        }
    }
}