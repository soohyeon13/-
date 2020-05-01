package 백준

import java.util.*
import kotlin.Comparator

private val state = intArrayOf(0, 1, 2, 3)
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = Array(n) { IntArray(n) { 0 } }
    val appleCnt = br.readLine().toInt()
    val appleQueue: Queue<Apple> = LinkedList()
    var time = 0
    for (i in 0 until appleCnt) {
        val apple = br.readLine().split(" ").map { it.toInt() }
        arr[apple[0] - 1][apple[1] - 1] = 1
    }
    appleQueue.add(Apple(0, 0))
    var currentState = 1
    val stateChangeCnt = br.readLine().toInt()
    val changes: PriorityQueue<State> = PriorityQueue(Comparator<State> { t, t1 ->
        if (t.changeTime > t1.changeTime) 1
        else -1
    })
    for (i in 0 until stateChangeCnt) {
        val s = br.readLine().split(" ")
        changes.add(State(s[0].toInt(),s[1]))
    }
    var nx = 0
    var ny = 0
    while (true) {
        if (changes.isNotEmpty() && changes.peek().changeTime == time) {
            val c = changes.poll()
            if (c.changeState == "D") currentState = (currentState + 1) % 4
            else {
                currentState = if (currentState == 0) 3 else currentState - 1
            }
        }
        nx += dx[currentState]
        ny += dy[currentState]
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) break
        if (appleQueue.contains(Apple(nx, ny)))  break
        appleQueue.add(Apple(nx, ny))
        if (arr[nx][ny] == 1) {
            arr[nx][ny] = 0
        }else if (arr[nx][ny] != 1) {
            appleQueue.poll()
        }
        time++
    }
    time+=1
    println(time)
    bw.flush()
}

data class Apple(
        val x: Int,
        val y: Int
)

data class State(
        val changeTime: Int,
        val changeState: String
)