package 카카오인턴대비.level2

import java.util.*
import kotlin.collections.ArrayList

class Level2Func {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val queue: Queue<Int> = LinkedList()
        val arr = ArrayList<Int>()
        for (i in progresses.indices) {
            var day = (100 - progresses[i]) / speeds[i]
            if ((100 - progresses[i]) % speeds[i] != 0) day++
            queue.add(day)
        }
        println(queue.toString())
        while (!queue.isEmpty()) {
            val q = queue.poll()
            var dayCount = 1
            while (!queue.isEmpty() && q >= queue.peek()) {
                queue.poll()
                dayCount += 1
            }
            arr.add(dayCount)
        }
        return arr.toIntArray()
    }
}