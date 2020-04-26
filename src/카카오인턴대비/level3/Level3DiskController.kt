package 카카오인턴대비.level3

import java.util.*

class Level3DiskController {
    fun solution(jobs: Array<IntArray>): Int {
        var arr = jobs.map { it[0] to it[1] }.sortedBy { it.first }
        var queue  = PriorityQueue<Pair<Int,Int>>(compareBy { it.second })
        var current  = 0
        var sum = 0
        while (!arr.isEmpty() || !queue.isEmpty()) {
            val c = arr.takeWhile { it.first <=current }
            println(c.toString())
            arr = arr.drop(c.size)
            if (queue.isEmpty()) {
                current = arr.first().first
            }else {
                val a = queue.poll()
                current += a.second
                sum += current - a.first
            }
        }
        return sum/jobs.size
    }
}