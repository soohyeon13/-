package 백준

import java.util.*
import kotlin.collections.ArrayList

private val answers = ArrayList<String>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").toTypedArray()
    val visited = Array(10){false}
    dfs(arr,visited,"",n+1)
    val a = answers.sorted()
    println(a[a.size-1])
    println(a[0])
    bw.flush()
}
private fun dfs(arr: Array<String>,visited : Array<Boolean>,key:String,size : Int) {
    if (key.length == size) {
        if (check(key,arr)) {
            answers.add(key)
        }
        return
    }
    if (key.length > size) return
    for (i in 0..9) {
        if (!visited[i]) {
            visited[i] = true
            dfs(arr,visited,key+i.toString(),size)
            visited[i] = false
        }
    }
}
private fun check(key:String,arr:Array<String>) : Boolean {
    for (i in 1 until key.length) {
        if (arr[i-1] == "<") {
            if (key[i-1].toInt() > key[i].toInt()) return false
        }else {
            if (key[i-1].toInt() < key[i].toInt()) return false
        }
    }
    return true
}