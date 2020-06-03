package 백준

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,k) = br.readLine().split(" ").map { it.toInt() }
    val arr = ArrayList<Int>()
    val visited = BooleanArray(361)
    val a = br.readLine().split(" ").map { it.toInt() }
    for (i in 0 until n) {
        arr.add(a[i])
    }
    val b = br.readLine().split(" ").map { it.toInt() }
    val queue : Queue<Int> = LinkedList()
    for (element in arr) {
        queue.offer(element)
        visited[element] = true
    }
    while (!queue.isEmpty()) {
        val q = queue.poll()
        val size = arr.size
        for (i in 0 until size) {
            val p = (q + arr[i]) % 360
            val m = (Math.abs(q-arr[i])) % 360
            if (!visited[p]) {
                visited[p] = true
                queue.offer(p)
                arr.add(p)
            }
            if (!visited[m]) {
                visited[m] = true
                queue.offer(m)
                arr.add(m)
            }
        }
    }
    for (i in b.indices) {
        if (visited[i]) println("YES")
        else println("NO")
    }
    bw.flush()
}