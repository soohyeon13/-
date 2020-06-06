package 앱데브매칭2020

class Solution1 {
    fun solution(moves: Array<String>): Int {
        var answer  = 0
        val map = Array(1010){BooleanArray(1010)}
        var startX = 500
        var startY = 500
        map[startX][startY] = true
        for (i in moves.indices) {
            when(moves[i]) {
                "U" -> {
                    startX -=1
                }
                "R" -> {
                    startY +=1
                }
                "D" -> {
                    startX +=1
                }
                "L" -> {
                    startY -=1
                }
            }
            map[startX][startY] = true
        }
        for (i in map.indices) {
            for (j in map[0].indices) {
                println()
                if (i+1 <1010 || j+1 <1010) {
                    if (map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) {
                        answer += 1
                    }
                }
            }
        }
        return answer
    }
}