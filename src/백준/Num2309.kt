package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var total =0
    val list = LinkedList<Int>()
    for (i in 0 until 9) {
        val len = br.readLine().toInt()
        total += len
        list.add(len)
    }
    loop@for (i in 0 until list.size-1) {
        for (j in i +1 until list.size) {
            if (total - (list[i] + list[j]) == 100) {
                val b = list[j]
                val a = list[i]
                list.remove(a)
                list.remove(b)
                break@loop
            }
        }
    }
    list.sort()
    for (i in list.indices) {
        println(list[i])
    }
    bw.flush()
}