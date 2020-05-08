package 백준

import java.util.*
import kotlin.collections.ArrayList

private var answer = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val str = br.readLine()
    val pattern = br.readLine()
    val arr = kmp(str,pattern)
    val sb = StringBuilder()
    for (i in arr.indices) {
        sb.append((arr[i] +1)).append(" ")
    }
    println(sb.toString())
    bw.flush()
}

private fun getPi(pattern : String) : IntArray{
    val m = pattern.length
    var j = 0
    val p = pattern.toCharArray()
    val pi = IntArray(m)
    for (i in 1 until m) {
        while (j >0 && p[i] != p[j]) {
            j = pi[j-1]
        }
        if (p[i] == p[j]) {
            pi[i] = ++j
        }
    }
    return pi
}
private fun kmp(word : String, pattern : String) : ArrayList<Int> {
    val list = ArrayList<Int>()
    val pi = getPi(pattern)
    val n = word.length
    val m = pattern.length
    var j = 0
    val w = word.toCharArray()
    val p = pattern.toCharArray()
    for (i in 0 until n) {
        while (j > 0 && w[i] != p[j]) {
            j = pi[j-1]
        }
        if(w[i] == p[j]) {
            if (j == m -1) {
                list.add(i-m+1)
                j = pi[j]
            }else {
                j++
            }
        }
    }
    return list
}
