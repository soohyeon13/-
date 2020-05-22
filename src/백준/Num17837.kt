package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var chessArr: Array<Array<LinkedList<Chess>>>
private lateinit var chessMap: Array<IntArray>
private lateinit var chessSequence: Array<Chess>
private var check = false
private val dx = intArrayOf(0, 0, -1, 1)
private val dy = intArrayOf(1, -1, 0, 0)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    chessMap = Array(n + 2) { IntArray(n + 2) { 2 } }
    chessArr = Array(n + 2) { Array(n + 2) { LinkedList<Chess>() } }
    chessSequence = Array(k + 1) { Chess(0, 0, 0, 0) }
    for (i in 1..n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in 1..n) {
            chessMap[i][j] = row[j - 1]
        }
    }
    for (i in 0 until k) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        chessArr[a][b].offer(Chess(a, b, i + 1, c))
        chessSequence[i + 1] = (Chess(a, b, i + 1, c))
    }
    var answer = 1
    var index = 0
    loop@ while (true) {
        val q = chessSequence[index % 4 + 1]
        val nx = q.x + dx[q.dir - 1]
        val ny = q.y + dy[q.dir - 1]
        when (chessMap[nx][ny]) {
            0 -> {
                white(q, nx, ny)
                if (chessArr[nx][ny].size >= 4) break@loop
            }
            1 -> {
                red(q, nx, ny)
                if (chessArr[nx][ny].size >= 4) break@loop
            }
            2 -> {
                blue(q)
                if (check) break@loop
            }
        }
        if (q.position == 1) {
            if (answer > 1000) {
                answer = -1
                break@loop
            }
            answer += 1
        }
        index += 1
    }
    println(answer)
    bw.flush()
}

private fun blue(chess: Chess) {
    check = false
    var size = chessArr[chess.x][chess.y].size
    val direction =
            if (chess.dir == 1) 2 else if (chess.dir == 2) 1 else if (chess.dir == 3) 4 else 3
    val nnx = chess.x + dx[direction - 1]
    val nny = chess.y + dy[direction - 1]
    if (chessMap[nnx][nny] == 2) {
        for (i in 0 until size) {
            val c = chessArr[chess.x][chess.y].removeFirst()
            if (c.position == chess.position) {
                chessSequence[c.position] = Chess(chess.x, chess.y, c.position, direction)
                chessArr[chess.x][chess.y].addLast(Chess(chess.x, chess.y, c.position, direction))
            } else {
                chessArr[chess.x][chess.y].addLast(c)
            }
        }
    } else {
        for (j in 0 until size) {
            val c = chessArr[chess.x][chess.y].removeFirst()
            if (c.position == chess.position) {
                chessArr[nnx][nny].addLast(Chess(nnx, nny, c.position, direction))
                chessSequence[c.position] = Chess(nnx, nny, c.position, direction)
                while (!chessArr[chess.x][chess.y].isEmpty()) {
                    val nc = chessArr[chess.x][chess.y].removeFirst()
                    chessArr[nnx][nny].addLast(Chess(nnx, nny, nc.position, nc.dir))
                    chessSequence[c.position] = Chess(nnx, nny, nc.position, nc.dir)
                }
                break
            } else {
                chessArr[chess.x][chess.y].addLast(c)
            }
        }
        if (chessArr[nnx][nny].size >= 4) check = true
    }
}

private fun red(chess: Chess, nx: Int, ny: Int) {
    var size = chessArr[chess.x][chess.y].size
    val c = chessArr[chess.x][chess.y].removeFirst()
    if (c.position == chess.position) {
        if (size == 1) {
            chessArr[nx][ny].addLast(Chess(nx, ny, c.position, c.dir))
            chessSequence[c.position] = Chess(nx, ny, c.position, c.dir)
        } else {
            while (!chessArr[chess.x][chess.y].isEmpty()) {
                val nc = chessArr[chess.x][chess.y].removeLast()
                chessArr[nx][ny].addLast(Chess(nx, ny, nc.position, nc.dir))
                chessSequence[nc.position] = Chess(nx, ny, nc.position, nc.dir)
            }
            chessSequence[c.position] = Chess(nx, ny, c.position, c.dir)
            chessArr[nx][ny].addLast(Chess(nx, ny, c.position, c.dir))
        }
    } else {
        chessArr[chess.x][chess.y].addLast(c)
        size -= 1
        while (size > 0) {
            val nc = chessArr[chess.x][chess.y].removeFirst()
            if (nc.position == c.position) {
                size -= 1
                for (j in 0 until size) {
                    val nnc = chessArr[chess.x][chess.y].removeFirst()
                    chessArr[nx][ny].addLast(Chess(nx, ny, nnc.position, nnc.dir))
                    chessSequence[nnc.position] = Chess(nx, ny, nnc.position, nnc.dir)
                }
                chessArr[nx][ny].addLast(Chess(nx, ny, nc.position, nc.dir))
                chessSequence[nc.position] = Chess(nx, ny, nc.position, nc.dir)
                break
            } else {
                chessArr[chess.x][chess.y].addLast(nc)
            }
            size -= 1
        }
    }
}

private fun white(chess: Chess, nx: Int, ny: Int) {
    var size = chessArr[chess.x][chess.y].size
    val c = chessArr[chess.x][chess.y].removeFirst()
    if (c.position == chess.position) {
        chessArr[nx][ny].addLast(Chess(nx, ny, c.position, c.dir))
        chessSequence[chess.position] = (Chess(nx, ny, c.position, c.dir))
        size -= 1
        for (i in 0 until size) {
            val ch = chessArr[chess.x][chess.y].removeFirst()
            chessSequence[ch.position] = Chess(nx, ny, ch.position, ch.dir)
            chessArr[nx][ny].addLast(Chess(nx, ny, ch.position, ch.dir))
        }
    } else {
        chessArr[chess.x][chess.y].addLast(c)
        size -= 1
        while (size > 0) {
            val ch = chessArr[chess.x][chess.y].removeFirst()
            if (ch.position == chess.position) {
                chessArr[nx][ny].addLast(Chess(nx, ny, ch.position, ch.dir))
                chessSequence[chess.position] = Chess(nx, ny, ch.position, ch.dir)
                size -= 1
                if (size != 0) {
                    for (i in 0 until size) {
                        val cch = chessArr[chess.x][chess.y].removeFirst()
                        chessSequence[cch.position] = Chess(nx, ny, cch.position, cch.dir)
                        chessArr[nx][ny].addLast(Chess(nx, ny, cch.position, cch.dir))
                    }
                }
            } else {
                chessArr[chess.x][chess.y].addLast(ch)
            }
        }
    }
}

private data class Chess(
        val x: Int,
        val y: Int,
        val position: Int,
        val dir: Int
)