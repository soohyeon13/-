package devmatching

import java.util.*
import kotlin.collections.HashMap

class Solution3 {
    fun solution(numbers: IntArray, k : Int) : Int {
        return  bfs(numbers,k)
    }

    private fun bfs(numbers: IntArray, k: Int): Int {
        val map = HashMap<IntArray,Boolean>()
        var cnt =  1
        val queue : Queue<IntArray> = LinkedList()
        queue.add(numbers)
        map[numbers] = true
        while (!queue.isEmpty()) {
            val a = queue.poll()
            for (i in a.indices) {
                for (j in i+1 until a.size) {
                    swap(i,j,a)
                    if (!map.containsKey(a)) queue.add(a)
                    swap(i,j,a)
                }
            }
            cnt++
        }
        return cnt
    }

    private fun swap(i: Int, j: Int, a: IntArray) {
        val temp = a[i]
        a[i] = a[j]
        a[j] = temp
    }
}

fun main() {
    val sol = Solution3()
    val a = intArrayOf(3,7,2,8,6,4,5,1)
    println(sol.solution(a,3))
}