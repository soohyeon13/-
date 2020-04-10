package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().toInt()
    for(i in 0 until cnt) {
        val decimal = br.readLine().split(" ")
        val command = Array<String>(10000){""}
        val visited = Array<Boolean>(10000){false}
        val queue : Queue<Int> = LinkedList<Int>()
        var n = decimal[0].toInt()
        var m = decimal[1].toInt()
        visited[n] = true
        queue.add(n)
        Arrays.fill(command,"")
        while (!queue.isEmpty() && !visited[m]) {
            val now = queue.poll()
            val D = (2*now) %10000
            val S = if(now == 0)  9999 else now-1
            val L = (now%1000) *10 + now/1000
            val R = (now %10) * 1000 + now/10
            if (!visited[D]) {
                queue.add(D)
                visited[D] =true
                command[D] = command[now] + "D"
            }
            if (!visited[S]) {
                queue.add(S)
                visited[S] =true
                command[S] = command[now] +"S"
            }
            if(!visited[L]) {
                queue.add(L)
                visited[L] =true
                command[L] = command[now] + "L"
            }
            if (!visited[R]) {
                queue.add(R)
                visited[R]= true
                command[R] = command[now] +"R"
            }
        }
        println(command[m])
    }
    bw.flush()
}