package 백준

import java.util.*

//F ,     S ,     G ,     U ,            D
//총 층수/ 현재 층/ 가야될곳/ 올라갈수있는 층수/ 내려갈수 있는 층수

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val F = cnt[0].toInt()
    var S = cnt[1].toInt()
    val G = cnt[2].toInt()
    val U = cnt[3].toInt()
    val D = cnt[4].toInt()
    val arr = IntArray(F + 1) { 0 }
    println(bfs(F, S, G, U, D, arr))
    bw.flush()
}

private fun bfs(floor: Int, start: Int, end: Int, up: Int, down: Int, arr: IntArray): String {
    val queue: Queue<Int> = LinkedList<Int>()
    queue.add(start)
    arr[start] = 1
    while (!queue.isEmpty()) {
        val currentPosition = queue.poll()
        if (currentPosition == end) {
            return (arr[currentPosition] - 1).toString()
        }
        if (currentPosition + up <= floor) {
            if (arr[currentPosition + up] == 0) {
                arr[currentPosition + up] = arr[currentPosition] + 1
                queue.add(currentPosition + up)
            }
        }
        if (currentPosition - down > 0) {
            if (arr[currentPosition - down] == 0) {
                arr[currentPosition- down] = arr[currentPosition] +1
                queue.add(currentPosition-down)
            }
        }
    }
    return "use the stairs"
}


















