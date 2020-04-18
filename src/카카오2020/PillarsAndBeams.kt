package 카카오2020

class PillarsAndBeams {
    private lateinit var cols :Array<BooleanArray>
    private lateinit var rows :Array<BooleanArray>
    private val BUILD = 1
    private val DELETE = 0
    private val PILLARS = 0
    private val BEAMS = 1
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        var count = 0
        cols = Array(n+3){BooleanArray(n+3)}
        rows = Array(n+3){BooleanArray(n+3)}
        for (i in build_frame.indices) {
            val x = build_frame[i][0] +1
            val y = build_frame[i][1] +1
            if (build_frame[i][2] == PILLARS) {
                if (build_frame[i][3] == BUILD && isExistCol(x,y)) {
                    cols[x][y] = true
                    count +=1
                }
                if (build_frame[i][3] == DELETE && isRemove(x,y,PILLARS,n)) {
                    cols[x][y] =false
                    count -=1
                }
            }else {
                if (build_frame[i][3] == BUILD && isExistRow(x,y)) {
                    rows[x][y] = true
                }
                if(build_frame[i][3] == DELETE && isRemove(x,y,BEAMS,n)) {
                    rows[x][y] = false
                    count -=1
                }
            }
        }
        val answer = Array(count){IntArray(3)}
        var index = 0
        for (i in 1..n) {
            for (j in 1..n) {
                if (cols[i][j]) {
                    answer[index++] = intArrayOf(i-1,j-1,PILLARS)
                }
                if (rows[i][j]) {
                    answer[index++] = intArrayOf(i-1,j-1,BEAMS)
                }
            }
        }
        return answer
    }

    private fun isRemove(x: Int, y: Int, type: Int, n: Int): Boolean {
        var result = false
        if (type == PILLARS) cols[x][y] =false
        else rows[x][y] =false

        loop@for (i in 1 .. n) {
            for (j in 1..n+1) {
                if (cols[i][j] && !isExistCol(i,j)) {
                    result = false
                    break@loop
                }
                if (rows[i][j] && !isExistRow(i,j)) {
                    result = false
                    break@loop
                }
            }
        }
        if (type == PILLARS) cols[x][y] = true
        else rows[x][y] = true
        return result
    }

    private fun isExistRow(x: Int, y: Int): Boolean {
        return cols[x][y-1] || cols[x+1][y-1] || (rows[x-1][y] && rows[x+1][y])
    }

    private fun isExistCol(x:Int,y:Int) : Boolean {
        return cols[x][y-1] || cols[x+1][y-1] || (rows[x-1][y] && rows[x+1][y])
    }
}