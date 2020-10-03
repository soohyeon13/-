package 백준

import java.util.*
import kotlin.collections.ArrayList

private val arr = arrayOf("9","8","7","6","5","4","3","2","1","0")
private val answers = ArrayList<Long>()
fun main() {
    val input = System.`in`.bufferedReader()
    val N = input.readLine().toInt()
    for (i in 1 .. 10) {
        val visited = BooleanArray(10)
        combination(visited,0,i)
    }
    answers.sort()
    if (N >= answers.size) println(-1)
    else println(answers[N-1])
}

private fun combination(visited:BooleanArray,start:Int,r:Int){
    if (r == 0) {
        val sb = StringBuilder()
        for (i in visited.indices) {
            if (visited[i]) sb.append(arr[i])
        }
        answers.add(sb.toString().toLong())
    }

    for (i in start until arr.size) {
        visited[i] = true
        combination(visited,i+1,r-1)
        visited[i] = false
    }
}