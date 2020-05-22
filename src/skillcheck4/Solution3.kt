package skillcheck4

private lateinit var copyBlock : Array<IntArray>
class Solution3 {
    fun solution(board: Array<IntArray>): Int {
        var answer = 0
        copyBlock = board.clone()
        loop@while (true) {
            for (i in 0 until board.size-1) {
                for (j in 0 until board.size-1) {
                    if (i <board.size-2) {
                        if (blockCheck(i,j,3,2)) {
                            removeBlock(i,j,3,2)
                            answer +=1
                            continue@loop
                        }
                    }
                    if (j < board.size-2) {
                        if (blockCheck(i,j,2,3))  {
                            removeBlock(i,j,2,3)
                            answer +=1
                            continue@loop
                        }
                    }
                    if (i == board.size-2 && j == board.size-2) break@loop
                }
            }
        }
        return answer
    }

    private fun removeBlock(x:Int,y:Int,start: Int, end : Int) {
        for (i in 0 until start) {
            for (j in 0 until end) {
                copyBlock[x+i][y+j] = 0
            }
        }
    }

    private fun blockCheck(x: Int, y: Int, start: Int, end: Int): Boolean {
        var cnt = 0
        var areaNum = 0
        for (i in 0 until start) {
            for (j in 0 until end) {
                if (copyBlock[x+i][y+j] == 0) {
                    if (!emptyBlock(x+i,y+j)) return false
                   cnt +=1
                }else {
                    if (areaNum != 0 && copyBlock[x+i][y+j] != areaNum) return false
                    areaNum = copyBlock[x+i][y+j]
                }
            }
        }
        return cnt == 2
    }
    private fun emptyBlock(x: Int, y: Int) : Boolean {
        for (i in 0 until x) {
            if (copyBlock[i][y] !=0) return false
        }
        return true
    }
}