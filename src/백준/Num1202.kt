package 백준

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val jewelrys = ArrayList<Pair<Int,Int>>()
    var totalMoney = 0
    val bags = ArrayList<Int>()
    val queue = PriorityQueue<Int>(reverseOrder())
    for(i in 0 until cnt[0].toInt()) {
        val a = br.readLine().split(" ")
        jewelrys.add(Pair(a[0].toInt(),a[1].toInt()))
    }
    jewelrys.sortedBy { (weight,_) -> weight }
    for (i in 0 until cnt[1].toInt()) {
        val a = br.readLine().toInt()
        bags.add(a)
    }
    bags.sort()
    var index =0
    loop@for (i in bags.indices) {
        var check =true
        while (check) {
            if (index == cnt[0].toInt()) {
                totalMoney += queue.poll()
                break@loop
            }
            if (bags[i] >= jewelrys[index].first) {
                queue.add(jewelrys[index].second)
                index +=1
            }else {
                totalMoney += queue.poll()
                check = false
            }
        }
    }
    println(totalMoney)
    bw.flush()
}