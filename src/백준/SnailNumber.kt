package 백준

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(1, 0, -1, 0)
private lateinit var snailMap: Array<IntArray>
fun main() {
    val input = System.`in`.bufferedReader()
    val initializeIndex = 0
    val initializeNumber = 1
    val (row, column) = input.readLine().split(" ").map { it.toInt() }
    snailMap = Array(row) { IntArray(column) }
    var currentX = initializeIndex
    var currentY = initializeIndex
    var currentDir = initializeIndex
    var snailNumber = initializeNumber
    snailMap[currentX][currentY] = snailNumber++
    while (true) {
        val nx = currentX + dx[currentDir]
        val ny = currentY + dy[currentDir]
        if (isCheckRange(nx, ny, row, column)) {
            currentDir = (currentDir + 1) % 4
            continue
        }
        if (isCheckDone(currentX, currentY, row, column)) break

        if (snailMap[nx][ny] != 0) {
            currentDir = (currentDir + 1) % 4
            continue
        }
        snailMap[nx][ny] = snailNumber++
        currentX = nx
        currentY = ny
    }
    printSnail()
}

private fun isCheckRange(nextX: Int, nextY: Int, row: Int, column: Int): Boolean {
    return (nextX < 0 || nextY < 0 || nextX >= row || nextY >= column)
}

private fun isCheckDone(currentX: Int, currentY: Int, row: Int, column: Int): Boolean {
    var zeroCount = 0
    for (i in 0 until 4) {
        val checkX = currentX + dx[i]
        val checkY = currentY + dy[i]
        if (isCheckRange(checkX, checkY, row, column)) continue
        val number = snailMap[checkX][checkY]
        if (number != 0) zeroCount++
        if (zeroCount == 4) return true
    }
    return false
}

private fun printSnail() {
    for (i in snailMap.indices) {
        println(snailMap[i].contentToString())
    }
}