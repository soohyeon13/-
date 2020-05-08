package 백준

import java.util.*
import kotlin.Comparator

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(n) }
    val land = Array(n) { IntArray(n) { 5 } }
    val queueLand = Array(n) {
        Array(n) {
            PriorityQueue<Tree>(Comparator<Tree> { t1, t2 ->
                if (t1.depth > t2.depth) 1
                else if (t1.depth == t2.depth) {
                    if (t1.age > t2.age) 1
                    else -1
                }else -1
            })
        }
    }
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    for (i in 0 until m) {
        val (x, y, z) = br.readLine().split(" ").map { it.toInt() }
        queueLand[x - 1][y - 1].offer(Tree(x - 1, y - 1, z,0))
    }
    var year = 0
    val dead: Queue<Tree> = LinkedList()
    val breeding: Queue<Tree> = LinkedList()
    while (year < k) {
        //봄
        for (i in arr.indices) {
            for (j in arr.indices) {
                val size = queueLand[i][j].size
                if (size == 0) continue
                for (t in 0 until size) {
                    val q = queueLand[i][j].poll()
                    if (land[q.x][q.y] >= q.age) {
                        land[q.x][q.y] -= q.age
                        queueLand[q.x][q.y].offer(Tree(q.x, q.y, q.age + 1,q.depth +1))
                        if ((q.age + 1) % 5 == 0) breeding.add(Tree(q.x, q.y, q.age + 1,q.depth+1))
                    } else {
                        dead.add(Tree(q.x, q.y, q.age,q.depth))
                    }
                }
            }
        }
        //여름
        while (!dead.isEmpty()) {
            val d = dead.poll()
            land[d.x][d.y] += d.age / 2
        }
        //가을
        while (!breeding.isEmpty()) {
            val breed = breeding.poll()
            for (i in 0 until 8) {
                val nx = breed.x + dx[i]
                val ny = breed.y + dy[i]
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue
                queueLand[nx][ny].offer(Tree(nx, ny, 1,breed.depth))
            }
        }
        //겨울
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                land[i][j] += arr[i][j]
            }
        }
        year += 1
    }
    var answer = 0
    for (i in queueLand.indices) {
        for (j in queueLand[i].indices) {
            answer += queueLand[i][j].size
        }
    }
    println(answer)
    bw.flush()
}

private data class Tree(
        val x: Int,
        val y: Int,
        var age: Int,
        val depth : Int
)