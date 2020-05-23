package 섬머코딩2020

import java.util.*

class Solution2 {
    fun solution(n: Long): Long {
        var answer: Long = 0
        var add : Long= 1
        val queue : Queue<Int> = LinkedList()
        var N = n
        while (N>0) {
            queue.offer((N%2).toInt())
            N /= 2
        }

        while (!queue.isEmpty()) {
            answer += queue.poll() * add
            add *=3
        }
        return answer
    }
}