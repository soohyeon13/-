package 카카오2020

class BlockGame {
    private var N: Int = 0
    private lateinit var copyBoard: Array<IntArray>
    fun solution(board: Array<IntArray>): Int {
        copyBoard = board.clone()
        var endPoint = true
        var answer = 0
        N = board.size
        while (endPoint) {
            println("시작")
            loop@ for (i in 0 .. copyBoard.size - 2) {
                for (j in 0 .. copyBoard.size - 2) {
                    if (verticalCheck(j, i)) {
                        println("vertical j : $j i : $i")
                        answer += 1
                        verticalConvert(j, i)
                        break@loop
                    }
                    if (horizontalCheck(j, i)) {
                        println("horizon j : $j i : $i")
                        answer += 1
                        horizontalConvert(j, i)
                        break@loop
                    }
                    if (i == N - 2 && j == N - 2) endPoint = false
                }
            }
        }
        return answer
    }

    private fun horizontalConvert(x: Int, y: Int) {
        for (i in 0 until 2) {
            for (j in 0 until 3) {
                copyBoard[x + i][y + j] = 0
            }
        }
    }

    private fun verticalConvert(x: Int, y: Int) {
        for (i in 0 until 3) {
            for (j in 0 until 2) {
                copyBoard[x + i][y + j] = 0
            }
        }
    }

    private fun verticalCheck(x: Int, y: Int): Boolean {
        if (x + 2 >= N || y + 1 >= N) return false
        var saveIndex = 0
        var cnt = 0
        for (i in 0 until 3) {
            for (j in 0 until 2) {
                if (saveIndex != 0 && saveIndex == copyBoard[x + i][y + j]) {
                    continue
                } else if (saveIndex != 0 && saveIndex != copyBoard[x + i][y + j]) {
                    if (copyBoard[x + i][y + j] != 0) return false
                }
                if (copyBoard[x + i][y + j] == 0) {
                    for (k in 0 until x + i) {
                        if (copyBoard[k][y + j] != 0) return false
                    }
                    cnt += 1
                } else {
                    saveIndex = copyBoard[x + i][y + j]
                }
            }
        }
        return cnt == 2
    }

    private fun horizontalCheck(x: Int, y: Int): Boolean {
        if (x + 1 >= N || y + 2 >= N) return false
        var saveIndex = 0
        var cnt = 0
        for (i in 0 until 2) {
            for (j in 0 until 3) {
                if (saveIndex != 0 && saveIndex == copyBoard[x + i][y + j]) {
                    continue
                } else if (saveIndex != 0 && saveIndex != copyBoard[x + i][y + j]) {
                    if (copyBoard[x + i][y + j] != 0) return false
                }
                if (copyBoard[x + i][y + j] == 0) {
                    for (k in 0 until x + i) {
                        if (copyBoard[k][y + j] != 0) return false
                    }
                    cnt += 1
                } else {
                    saveIndex = copyBoard[x + i][y + j]
                }
            }
        }
        return cnt == 2
    }
}