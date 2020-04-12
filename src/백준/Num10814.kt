package 백준

import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().toInt()
    val a = ArrayList<Pair<Int,String>>()
    for (i in 0 until cnt) {
        val b = br.readLine().split(" ")
        val c = Pair(b[0].toInt(),b[1])
        a.add(c)
    }
    val b =a.sortedBy { (key,_)-> key }
    for (i in b.indices) {
        val d = StringBuilder()
        d.append("${b[i].first} ${b[i].second}")
        println(d)
    }
}