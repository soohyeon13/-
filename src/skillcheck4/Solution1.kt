package skillcheck4

class Solution1 {
    private lateinit var copyBoard : Array<IntArray>
    fun solution(board: Array<IntArray>): Int {
        copyBoard = board.clone()
        var answer = 0
        loop@ while (true) {
            for (i in 0..board.size - 2) {
                for (j in 0..board[i].size-2) {
                    if (i <= board.size - 3) {
                        if (verticalCheck(i, j)) {
                            println("i :$i j :$j vertical")
                            answer += 1
                            verticalRemoveBlock(i,j)
                            continue@loop
                        }
                    }
                    if (j <= board[0].size - 3) {
                        if (horizontalCheck(i, j)) {
                            println("i :$i j :$j horizontal")
                            answer += 1
                            horizontalRemoveBlock(i,j)
                            continue@loop
                        }
                    }
                    if (i == board.size - 2 && j == board[0].size - 2) break@loop
                }
            }
        }
        return answer
    }

    private fun downBlock(x: Int, y: Int): Boolean {
        for (i in 0 until x) {
            if (copyBoard[i][y] != 0) return false
        }
        return true
    }
    private fun verticalRemoveBlock(x: Int, y: Int) {
        for (i in 0 until 3) {
            for (j in 0 until 2) {
                copyBoard[i+x][j+y] = 0
            }
        }
    }
    private fun horizontalRemoveBlock(x: Int, y: Int) {
        for (i in 0 until 2){
            for (j in 0 until 3) {
                copyBoard[i+x][j+y] = 0
            }
        }
    }
    private fun verticalCheck(x: Int, y: Int): Boolean {
        var save = 0
        var zeroCnt = 0
        for (i in 0 until 3) {
            for (j in 0 until 2) {
                if (copyBoard[i + x][j + y] == 0) {
                    if (downBlock(i, j)) zeroCnt += 1
                    else return false
                }
                if (copyBoard[i + x][j + y] != 0 && save == 0) {
                    save = copyBoard[i + x][j + y]
                } else if (save != copyBoard[i + x][j + y]) {
                    return false
                }
            }
        }
        return zeroCnt == 2
    }

    private fun horizontalCheck(x: Int, y: Int): Boolean {
        var save = 0
        var zeroCnt = 0
        for (i in 0 until 2) {
            for (j in 0 until 3) {
                if (copyBoard[i + x][j + y] == 0) {
                    if (downBlock(i, j)) zeroCnt += 1
                    else return false
                }
                if (copyBoard[i + x][j + y] != 0 && save == 0) {
                    save = copyBoard[i + x][j + y]
                } else if (save != copyBoard[i + x][j + y]) {
                    return false
                }
            }
        }
        println("x:$x y:$y cnt :$zeroCnt")
        return zeroCnt == 2
    }
}