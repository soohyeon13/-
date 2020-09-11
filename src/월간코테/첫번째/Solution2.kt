package 월간코테.첫번째

private val dx = intArrayOf(1, 0, -1)
private val dy = intArrayOf(0, 1, -1)

class Solution2 {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var index = 1
        val total = n * (n + 1) / 2
        val pyramid = Array(n) { Array(index++) { 0 } }
        var startX = 0
        var startY = 0
        var startDir = 0
        var number = 1
        pyramid[startX][startY] = number++
        while (true) {
            var nx = startX + dx[startDir]
            var ny = startY + dy[startDir]

            if (total < number) break

            if (isCheck(nx, ny, n)) {
                startDir = (startDir + 1) % 3
                continue
            }

            if (pyramid[nx][ny] != 0 && startDir == 2) {
                startDir = (startDir + 1) % 3
                startX += 1
                pyramid[startX][startY] = number++
                continue
            }

            if (pyramid[nx][ny] != 0) {
                startDir = (startDir + 1) % 3
                continue
            }

            pyramid[nx][ny] = number++
            startX = nx
            startY = ny
        }
        answer = pyramid.flatten().toIntArray()
        return answer
    }

    private fun isCheck(nx: Int, ny: Int, n: Int): Boolean {
        return nx < 0 || ny < 0 || nx >= n || ny >= n
    }
}

fun main() {
    val sol = Solution2()
    println(sol.solution(3).contentToString())
}