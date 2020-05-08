package 백준

import java.util.*
import kotlin.Comparator

fun main() {
    val arr = intArrayOf(1,2,5,3,5,7,7,4,6,7,8)
    val queue : PriorityQueue<Test> = PriorityQueue(Comparator<Test> { t1,t2 ->
        if (t1.a < t2.a) -1
        else 1
    })

    for (i in arr.indices) {
        queue.add(Test(arr[i]))
    }
    println(queue.toString())
    while (!queue.isEmpty()) {
        println(queue.poll())
    }
}
private data class Test(
        val a : Int
)