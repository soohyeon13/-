package 백준

private val map = Array(101){BooleanArray(101)}
private val RIGHT = 0
private val UP = 1
private val LEFT = 2
private val DOWN = 3
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val conditions = br.readLine().split(" ").map { it.toInt() }
        val x = conditions[0]
        val y = conditions[1]
        val d = conditions[2]
        val g = conditions[3]
        drawSquare(x,y,findDir(d,g))
    }
    var answer = 0
    for (i in 0 until 100) {
        for (j in 0 until 100) {
            if (map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) answer +=1
        }
    }
    println(answer)
    bw.flush()
}

private fun findDir(d : Int, g : Int) : ArrayList<Int> {
    val direction = ArrayList<Int>()
    direction.add(d)
    var generation = g
    while (generation-- > 0) {
        for (j in direction.size-1 downTo 0) {
            val dir = (direction[j] +1) %4
            direction.add(dir)
        }
    }
    return direction
}
private fun drawSquare(x:Int, y:Int, directions : ArrayList<Int>)  {
    map[x][y] = true
    var a = x
    var b = y
    for (i in directions.indices) {
        when(directions[i]) {
            RIGHT -> map[++a][b] =true
            UP -> map[a][--b] = true
            LEFT -> map[--a][b] = true
            DOWN -> map[a][++b] = true
        }
    }
}