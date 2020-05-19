package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val map = br.readLine().split(" ").map { it.toInt() }
    val queue : Queue<Cal> = LinkedList()
    queue.offer(Cal(map[0],0))
    var answer = 0
    var count = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.position == map.size-2) {
            if (q.num == map[map.size-1]) answer +=1
            continue
        }
        if (q.num + map[q.position+1] <=20){
            queue.offer(Cal(q.num + map[q.position+1],q.position+1))
        }
        if (q.num - map[q.position+1] >=0) {
            queue.offer(Cal(q.num-map[q.position+1],q.position+1))
        }
    }
    println(answer)
    bw.flush()
}

private data class Cal(
        val num : Int,
        val position : Int
)