package 백준

import kotlin.math.max

private lateinit var arr: Array<Array<String>>
private var answer = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    arr = Array(n) { Array(n) { "" } }
    for (i in 0 until n) {
        val row = br.readLine().toCharArray().map { it.toString() }
        for (j in row.indices) {
            arr[i][j] = row[j]
        }
    }
    for (i in arr.indices) {
        for (j in 0 until arr[i].size - 1) {
            swap(i, j, 1)
            findCandy()
            swap(i, j, 1)
        }
    }
    for (i in 0 until arr.size-1) {
        for (j in arr[i].indices) {
            swap(i, j, 0)
            findCandy()
            swap(i, j, 0)
        }
    }
    println(answer)
    bw.flush()
}

private fun findCandy() {
    for (i in arr.indices) {
        var cnt = 1
        for (j in 0 until arr[i].size - 1) {
            if (arr[i][j] == arr[i][j + 1]) cnt += 1
            else {
                answer = max(answer, cnt)
                cnt = 1
            }
        }
        answer = max(answer, cnt)
    }
    for (i in arr.indices) {
        var cnt = 1
        for (j in 0 until arr[i].size - 1) {
            if (arr[j][i] == arr[j + 1][i]) cnt += 1
            else {
                answer = max(answer, cnt)
                cnt = 1
            }
        }
        answer = max(answer, cnt)
    }
}

private fun swap(x: Int, y: Int, dir: Int) {
    if (dir == 1) {
        val temp = arr[x][y]
        arr[x][y] = arr[x][y + 1]
        arr[x][y + 1] = temp
    } else {
        val temp = arr[x][y]
        arr[x][y] = arr[x + 1][y]
        arr[x + 1][y] = temp
    }
}