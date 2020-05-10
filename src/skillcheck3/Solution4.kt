package skillcheck3

import java.util.*
import kotlin.math.max

class Solution4 {
    fun solution(operations: Array<String>): IntArray {
        val minQueue : PriorityQueue<Int> = PriorityQueue()
        val maxQueue : PriorityQueue<Int> = PriorityQueue(reverseOrder<Int>())
        for (i in operations.indices) {
            val arr = operations[i].split(" ")
            when(arr[0]) {
                "I" -> {
                    minQueue.add(arr[1].toInt())
                    maxQueue.add(arr[1].toInt())
                }
                "D" -> {
                    if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
                        if (arr[1] == "-1") {
                            val a = minQueue.poll()
                            maxQueue.remove(a)
                        }else {
                            val a= maxQueue.poll()
                            minQueue.remove(a)
                        }
                    }
                }
            }
        }
        val answer = IntArray(2)
        if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            answer[0] = maxQueue.poll()
            answer[1] = minQueue.poll()
        }else {
            answer[0] =0
            answer[1] = 0
        }
        return answer
    }
}