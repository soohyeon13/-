package 앱데브매칭2020

private var answer = 0
private val dx = intArrayOf(-1,0,1,0)
private val dy = intArrayOf(0,1,0,-1)
private var count = 1
class Solution2 {
    fun solution(board: Array<IntArray>): Int {
        loop@for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] !=  0) {
                    if (isCheckWinner(i,j, board)) break@loop
                }
            }
        }
        return answer
    }
    private fun isCheckWinner(x:Int,y:Int , board: Array<IntArray>) :Boolean {
        val color = board[x][y]
        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y+ dy[i]
            count = 1
            if (nx < 0 || ny < 0 || nx>=board.size || ny>= board.size) continue
            if (board[nx][ny] == color) {
                count++
                isCheck(i, nx, ny,board,color)
                if (count == 5){
                    answer = color
                    return true
                }
            }
        }
        return count == 5
    }
    private fun isCheck(dir : Int, x: Int, y: Int, board: Array<IntArray>, color : Int) {
        val nx = x + dx[dir]
        val ny = y + dy[dir]
        if (nx < 0 || ny < 0 || nx>=board.size || ny>= board.size) return
        if (board[nx][ny] == color) {
            count++
            isCheck(dir,nx,ny,board,color)
        }
    }
}