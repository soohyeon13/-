package 카카오인턴대비.level3

import java.util.*

class Level3ExternalWall {
    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        val queue: Queue<IntArray> = LinkedList()
        var answer = Int.MAX_VALUE
        queue.add(weak)
        val arr = dist.sortedByDescending { it }
        while (true) {
            val q = queue.poll()
            if (q[0] > n) break
            var left = 0
            var right = 0
            var index = 0
            while (right < q.size) {
                if (index >=  arr.size) {
                    break
                }
                if (q[right] - q[left] <= arr[index]) {
                    right++
                } else {
                    index++
                    left = right
                }
            }
            answer = if (index + 1 < answer) index + 1 else answer
            val list = IntArray(q.size)
            for (i in 1 until q.size) {
                list[i - 1] = q[i]
            }
            list[q.size - 1] = q[0] + n
            queue.add(list)
        }
        if (answer > arr.size) return -1
        return answer
    }
}

fun main() {
    val sol = Level3ExternalWall()
    val n = 12
    val weak = intArrayOf(1, 5, 6, 10)
    val dist = intArrayOf(1, 2, 3, 4)
    println(sol.solution(n, weak, dist))
}