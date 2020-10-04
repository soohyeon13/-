package 백준

private lateinit var classMap: Array<Array<String>>
private val emptySpace = ArrayList<Int>()
private val teachers = ArrayList<Teacher>()
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var n = 0
private var answer = "NO"
fun main() {
    val input = System.`in`.bufferedReader()
    val N = input.readLine().toInt()
    n = N
    var cnt = 0
    classMap = Array(N) { Array(N) { " " } }
    for (i in 0 until N) {
        val row = input.readLine().split(" ").map { it.toString() }.toTypedArray()
        for (j in row.indices) {
            if (row[j] == "T") teachers.add(Teacher(i, j))
            if (row[j] == "X") emptySpace.add(cnt)
            classMap[i][j] = row[j]
            cnt++
        }
    }
    val visited = BooleanArray(emptySpace.size)
    combination(visited, 0, 3)
    println(answer)
}

private fun combination(visited: BooleanArray, start: Int, r: Int) {
    if (answer == "YES") return
    if (r == 0) {
        val blockingIndex = ArrayList<Int>()
        for (i in visited.indices) {
            if (visited[i]) {
                val index = emptySpace[i]
                blockingIndex.add(index)
            }
        }
        avoidMonitor(blockingIndex)
        return
    }
    for (i in start until emptySpace.size) {
        visited[i] = true
        combination(visited, i + 1, r - 1)
        visited[i] = false
    }
}

private fun avoidMonitor(blockingIndex: ArrayList<Int>) {
    val copyMap = Array(n){Array(n){""} }
    for (i in classMap.indices) {
        copyMap[i] = classMap[i].copyOf()
    }
    for (i in blockingIndex.indices) {
        val x = blockingIndex[i] / n
        val y = blockingIndex[i] % n
        copyMap[x][y] = "O"
    }
    for (j in teachers.indices) {
        val teacherX = teachers[j].x
        val teacherY = teachers[j].y
        for (k in 0 until 4) {
            var nTeacherX = teacherX + dx[k]
            var nTeacherY = teacherY + dy[k]
            while (true) {
                if (nTeacherX < 0 || nTeacherY < 0 || nTeacherX >= n || nTeacherY >= n) break
                if (copyMap[nTeacherX][nTeacherY] == "O") break
                if (copyMap[nTeacherX][nTeacherY] == "S") {
                    return
                }
                copyMap[nTeacherX][nTeacherY] = "T"
                nTeacherX += dx[k]
                nTeacherY += dy[k]
            }
        }
    }
    answer = "YES"
}


private data class Teacher(
        val x: Int,
        val y: Int
)