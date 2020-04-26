package 카카오인턴대비.level3

import java.util.*

class Level3DoublePriority {
    fun solution(operations: Array<String>): IntArray {
        val maxQueue = PriorityQueue<Int>(reverseOrder())
        val minQueue = PriorityQueue<Int>()
        for (i in operations.indices) {
            val arr = operations[i].split(" ")
            when (arr[0]) {
                "I" -> {
                    maxQueue.add(arr[1].toInt())
                    minQueue.add(arr[1].toInt())
                }
                "D" -> {
                    if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
                        if (arr[1] == "1") {
                            val max = maxQueue.poll()
                            minQueue.remove(max)
                        } else {
                            val min = minQueue.poll()
                            maxQueue.remove(min)
                        }
                    }
                }
            }
        }
        if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            return intArrayOf(maxQueue.poll(),minQueue.poll())
        }else {
            return intArrayOf(0,0)
        }
    }
}