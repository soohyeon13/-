package 백준


private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private lateinit var map: Array<CharArray>
private var answer = 99999
private var N = 0
private var M = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    N = n
    M = m
    map = Array(N) { CharArray(M) }
    val coin = Array(2) { IntArray(2) }
    var index = 0
    for (i in 0 until N) {
        val row = br.readLine().toCharArray()
        for (j in row.indices) {
            map[i][j] = row[j]
            if (map[i][j] == 'o') {
                coin[index][0] = i
                coin[index][1] = j
                index += 1
            }
        }
    }
    val c1 = intArrayOf(coin[0][0], coin[0][1])
    val c2 = intArrayOf(coin[1][0], coin[1][1])
    moveCoin(1,c1,c2)
    if (answer ==99999) println(-1) else println(answer)
    bw.flush()
}

private fun moveCoin(cnt: Int, c1: IntArray, c2: IntArray) {
    if (cnt > 10 || cnt >= answer) {
        return
    }
    for (i in 0 until 4) {
        var x1 = c1[0] + dx[i]
        var y1 = c1[1] + dy[i]
        var x2 = c2[0] + dx[i]
        var y2 = c2[1] + dy[i]

        if (!isRange(x1,y1) && !isRange(x2,y2))continue
        if (!isRange(x1,y1)){
            answer = Math.min(answer,cnt)
            return
        }
        if (!isRange(x2,y2)) {
            answer = Math.min(answer,cnt)
            return
        }
        if (map[x1][y1] == '#') {
            x1 = c1[0]
            y1 = c1[1]
        }
        if (map[x2][y2]=='#') {
            x2 = c2[0]
            y2 = c2[1]
        }
        moveCoin(cnt+1, intArrayOf(x1,y1), intArrayOf(x2,y2))
    }
}

private fun isRange(x: Int, y: Int): Boolean = x >= 0 && y >= 0 && x < N && y < M
