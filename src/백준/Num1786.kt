package 백준

import java.util.*
import kotlin.collections.ArrayList

private var answer = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val str = br.readLine()
    val pattern = br.readLine()
    val a = kmp(str,pattern)
    println(answer)
}

private fun kmp(str: String,pattern:String) : ArrayList<Int> {
    val list = ArrayList<Int>()
    val pi = getPi(pattern)
    val n = str.length
    val m = pattern.length
    var j = 0
    val s = str.toCharArray()
    val p =pattern.toCharArray()
    for (i in 0 until n) {
        while (j>0 && s[i] != p[j]) {
            j = pi[j-1]
        }
        if (s[i] == p[j]) {
            if (j == m-1) {
                list.add(i-m+1)
                j = pi[j]
            }else {
                j++
            }
        }
    }
    return list
}

private fun getPi(pattern: String): Array<Int> {
    val m = pattern.length
    var j = 0
    var p = CharArray(m)
    val pi = Array(m){0}
    p = pattern.toCharArray()
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
