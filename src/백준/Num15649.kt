package 백준

import java.lang.StringBuilder

private val set = HashSet<String>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n){i -> i+1}
    perm(arr,0,n,m)
    val answer =set.sorted()
    answer.forEach { println(it.toString()) }
    bw.flush()
}

private fun perm(arr: Array<Int>,depth: Int,n : Int, k : Int) {
    if (depth == k) {
        val sb = StringBuilder()
        for (i in 0 until k) {
            sb.append(arr[i]).append(" ")
        }
        set.add(sb.toString())
        return
    }
    for (i in depth until n) {
        swap(arr,depth,i)
        perm(arr,depth+1,n,k)
        swap(arr,depth,i)
    }

}

private fun swap(arr : Array<Int>,depth: Int,i : Int) {
    val temp = arr[depth]
    arr[depth] = arr[i]
    arr[i] = temp
}