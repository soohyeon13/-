package 카카오인턴대비.level4

class Level4BlockGame {
    private lateinit var copyBoard: Array<IntArray>
    private var answer = 0
    fun solution(board: Array<IntArray>): Int {
        copyBoard = board.clone()
        loop@while (true) {
            for (i in 0 until board.size-1) {
                for (j in 0 until board.size-1) {
                    if (j < board.size-2) {
                        if (checkBlock(i,j,2,3)) {
                            removeBlock(i,j,2,3)
                            answer++
                            continue@loop
                        }
                    }
                    if (i < board.size-2) {
                        if (checkBlock(i,j,3,2)) {
                            removeBlock(i,j,3,2)
                            answer++
                            continue@loop
                        }
                    }
                    if (i == board.size-2 && j == board.size-2) {
                        break@loop
                    }
                }
            }
        }
        return answer
    }

    private fun removeBlock(a: Int, b: Int,start:Int,end:Int) {
        for (i in 0 until start) {
            for (j in 0 until end) {
                copyBoard[a+i][b+j] =0
            }
        }
    }
    private fun checkBlock(a:Int,b:Int,start:Int,end:Int): Boolean {
        var cnt = 0
        var num = 0
        for (i in 0 until start) {
            for (j in 0 until end) {
                if (copyBoard[a+i][b+j] !=0) {
                    if (num != 0 && num != copyBoard[a+i][b+j]) return false
                    num = copyBoard[a+i][b+j]
                    cnt++
                }else {
                    for (t in 0 until a+i) {
                        if (copyBoard[t][b+j] != 0) {
                            return false
                        }
                    }
                }
            }
        }
        return cnt == 4
    }
}