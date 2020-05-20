package 백준

import java.util.*

private lateinit var map: Array<Array<String>>
private lateinit var chessArr : Array<Array<LinkedList<Chess>>>
private val dx = intArrayOf(0,0,-1,1)
private val dy = intArrayOf(1,-1,0,0)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    map = Array(n + 1) { Array(n + 1) { "" } }
    for (i in 1 .. n) {
        val row = br.readLine().split(" ")
        for (j in 1.. row.size) {
            map[i][j] = row[j-1]
        }
    }
    chessArr = Array(n+1) { Array(n+1){LinkedList<Chess>() } }
    val chessQueue : Queue<Chess> = LinkedList()
    for (i in 0 until k) {
        val (a,b,c) = br.readLine().split(" ").map { it.toInt() }
        chessArr[a][b].add(Chess(a,b,c))
        chessQueue.offer(Chess(a,b,c))
    }
    while (true) {
        val q = chessQueue.poll()
        val nx = q.x + dx[q.dir-1]
        val ny = q.y + dy[q.dir-1]
        //범위 벗어났을때
        if (nx < 1 || ny < 1 || nx >n || ny > n) {
            val d =
                    if(q.dir == 2) 1 else if (q.dir ==1 ) 2 else if (q.dir == 3) 4 else 3
            chessArr[nx][ny].remove(Chess(q.x,q.y,q.dir))
            chessArr[nx][ny].add(Chess(q.x,q.y,d))
            chessQueue.offer(Chess(q.x,q.y,d))
        }
        //파란색
        if (map[nx][ny] == "2") {
            val d =
                    if(q.dir == 2) 1 else if (q.dir ==1 ) 2 else if (q.dir == 3) 4 else 3
            val nnx = nx + dx[d]
            val nny = ny + dy[d]
            if (map[nnx][nny] == "2") {
                chessArr[q.x][q.y].remove(Chess(q.x,q.y,q.dir))
                chessArr[q.x][q.y].add(Chess(q.x,q.y,d))
                chessQueue.offer(Chess(q.x,q.y,d))
            }else {
                
                chessArr[nnx][nny].add(Chess(q.x,q.y,d))
                chessQueue.offer(Chess(nnx,nny,d))
            }
        }
    }
}

private data class Chess(
        val x : Int,
        val y : Int,
        val dir : Int
)