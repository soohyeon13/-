package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val stones = br.readLine().split(" ")
    var total =0
    var index =0
    var check = true
    val queue : Queue<Triple<Int,Int,Int>> = LinkedList()
    stones.forEach { total += it.toInt() }
    if (total %3 !=0) println(0)
    else {
        queue.add(Triple(stones[0].toInt(),stones[1].toInt(),stones[2].toInt()))
        while (!queue.isEmpty() && index <10000) {
            val a = queue.poll()
            index++
            if (a.first == a.second && a.first == a.third && a.second == a.third) {
                println(1)
                check = false
                break
            }
            val A = a.first
            val B = a.second
            val C = a.third
            if (A<B) {
                val copyA = B-A
                val copyB = A*2
                queue.offer(Triple(copyA,copyB,C))
            }
            if (A>B) {
                val copyA = A-B
                val copyB = B*2
                queue.offer(Triple(copyA,copyB,C))
            }
            if (B<C) {
                val copyC = C-B
                val copyB = B*2
                queue.offer(Triple(A,copyB,copyC))
            }
            if (B>C) {
                val copyC = C*2
                val copyB = B-C
                queue.offer(Triple(A,copyB,copyC))
            }
            if (A>C) {
                val copyA = A-C
                val copyC = C*2
                queue.offer(Triple(copyA,B,copyC))
            }
            if (A<C) {
                val copyA = A*2
                val copyC = C-A
                queue.offer(Triple(copyA,B,copyC))
            }
        }
        if (check) println(0)
    }
    bw.flush()
}