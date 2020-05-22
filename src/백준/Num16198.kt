package 백준

import kotlin.math.max

private var answer = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val list = ArrayList<Int>()
    for (i in arr.indices) {
        list.add(arr[i])
    }
    for (i in 1 until n-1 ) {
        energy(list,0)
    }
    println(answer)
    bw.flush()
}

private fun energy(arr: ArrayList<Int>, sum : Int) {
    if (arr.size == 2) {
        answer = max(answer,sum)
        return
    }
    for (i in 1 until arr.size-1) {
        val list = ArrayList<Int>()
        val s = sum + (arr[i-1] * arr[i+1])
        for (j in arr.indices) {
            if (j != i) list.add(arr[j])
        }
        energy(list,s)
    }
}