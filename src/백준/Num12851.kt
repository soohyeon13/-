package 백준

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,k) = br.readLine().split(" ").map { it.toInt() }
    val queue : Queue<Hide> = LinkedList()
    val map = HashMap<Int,Int>()
    val check = HashMap<Int,Boolean>()
    check[n] = true
    queue.offer(Hide(n,0))
    var minTIme = Int.MAX_VALUE
    while (!queue.isEmpty()) {
        val q = queue.poll()
        println(q.toString())
        if (q.num == k) {
            if (!map.containsKey(q.time)) map[q.time] = 1
            else map[q.time] = map[q.time]!!.plus(1)
            minTIme = min(minTIme,q.time)
            continue
        }
        if (q.num +1 <=k) {
            if (!check.containsKey(q.num +1)) {
                queue.offer(Hide(q.num +1,q.time+1))
                check[q.num+1] = true
            }
        }
        if (q.num -1 > 0) {
            if (!check.containsKey(q.num-1)) {
                queue.offer(Hide(q.num - 1, q.time + 1))
                check[q.num-1] = true
            }
        }
        if (q.num *2 <=k) {
            if (!check.containsKey(q.num*2)) {
                queue.offer(Hide(q.num * 2, q.time + 1))
                check[q.num*2] = true
            }
        }
    }
    println(minTIme)
    println(map[minTIme])
}
private data class Hide(
        val num : Int,
        val time : Int
)