package 카카오인턴대비.level2

import java.util.*

class Level2Print {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 1
        val queue  = PriorityQueue<Int>(reverseOrder())
        for (element in priorities) {
            queue.add(element)
        }
        println(queue.toString())
        while (!queue.isEmpty()) {
            for (i in priorities.indices) {
                if (priorities[i] == queue.peek()) {
                    if (i == location) {
                        return answer
                    }
                    queue.poll()
                    answer++
                }
            }
        }
        return answer
    }
}