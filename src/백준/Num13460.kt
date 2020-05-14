package 백준

import java.util.*

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private lateinit var map: Array<Array<String>>
private var n = 0
private var m = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val N = br.readLine().split(" ").map { it.toInt() }
    n = N[0]
    m = N[1]
    map = Array(n) { Array(m) { "" } }
    var answer = -1
    var r: Red? = null
    var b: Blue? = null
    for (i in 0 until n) {
        val row = br.readLine().toCharArray()
        for (j in row.indices) {
            map[i][j] = row[j].toString()
            if (row[j] == 'R') r = Red(i, j)
            if (row[j] == 'B') b = Blue(i, j)
        }
    }
    val queue: Queue<Marble> = LinkedList()
    r?.let { red ->
        b?.let { blue ->
            queue.offer(Marble(red, blue, 0))
        }
    }
    loop@ while (!queue.isEmpty()) {
        val q = queue.poll()
        if (q.count > 10) {
            answer = -1
            break
        }
        for (i in 0 until 4) {
            var currentRx = q.red!!.x
            var currentRy = q.red.y
            var currentBx = q.blue!!.x
            var currentBy = q.blue.y
            var redGoalIn = false
            var blueGoalIn = false
            var rCheck = false
            var bCheck = false
            while (true) {
                var rnx = currentRx + dx[i]
                var rny = currentRy + dy[i]
                var bnx = currentBx + dx[i]
                var bny = currentBy + dy[i]
                if (rCheck && bCheck) break
                if (isCheck(rnx, rny)) {
                    rCheck = true
                    continue
                }
                if (isCheck(bnx, bny)) {
                    bCheck = true
                    continue
                }
                if (map[rnx][rny] == "O") {
                    redGoalIn = true
                    rCheck = true
                }
                if (map[bnx][bny] == "O") {
                    blueGoalIn = true
                    bCheck = true
                }
                if (!rCheck) {
                    currentRx = rnx
                    currentRy = rny
                }
                if (!bCheck) {
                    currentBx = bnx
                    currentBy = bny
                }
            }
            if (blueGoalIn) {
                answer = -1
                break@loop
            } else if (redGoalIn) {
                answer = q.count + 1
                break@loop
            }
            if (currentBx == currentRx && currentBy == currentRy) {
                when (i) {
                    0 -> {
                        if (q.red.x > q.blue.x) {
                            val red = Red(currentRx +1,currentRy)
                            val blue = Blue(currentBx,currentBy)
                            queue.offer(Marble(red,blue,q.count+1))
                        }else {
                            val red = Red(currentRx,currentRy)
                            val blue = Blue(currentBx +1,currentBy)
                            queue.offer(Marble(red,blue,q.count+1))
                        }
                    }
                    1 -> {
                        if (q.red.y > q.blue.y) {
                            val red = Red(currentRx, currentRy)
                            val blue = Blue(currentBx, currentBy - 1)
                            queue.offer(Marble(red, blue, q.count + 1))
                        } else {
                            val red = Red(currentRx, currentRy - 1)
                            val blue = Blue(currentBx, currentBy)
                            queue.offer(Marble(red, blue, q.count + 1))
                        }
                    }
                    2 -> {
                        if (q.red.x > q.blue.x) {
                            val red = Red(currentRx, currentRy)
                            val blue = Blue(currentBx -1, currentBy)
                            queue.offer(Marble(red, blue, q.count + 1))
                        } else {
                            val red = Red(currentRx-1, currentRy)
                            val blue = Blue(currentBx, currentBy)
                            queue.offer(Marble(red, blue, q.count + 1))
                        }
                    }
                    3 -> {
                        if (q.red.y > q.blue.y) {
                            val red = Red(currentRx, currentRy + 1)
                            val blue = Blue(currentBx, currentBy)
                            queue.offer(Marble(red, blue, q.count + 1))
                        } else {
                            val red = Red(currentRx, currentRy)
                            val blue = Blue(currentBx, currentBy + 1)
                            queue.offer(Marble(red, blue, q.count + 1))

                        }
                    }
                }
            }else {
                val red = Red(currentRx,currentRy)
                val blue = Blue(currentBx,currentBy)
                queue.offer(Marble(red,blue,q.count+1))
            }
        }
    }
    println(answer)
    bw.flush()
}

private fun isCheck(x: Int, y: Int): Boolean =
        x >= 0 && y >= 0 && x < n && y < m && map[x][y] != "#"


data class Marble(
        val red: Red?,
        val blue: Blue?,
        val count: Int
)

data class Red(
        val x: Int,
        val y: Int
)

data class Blue(
        val x: Int,
        val y: Int
)
