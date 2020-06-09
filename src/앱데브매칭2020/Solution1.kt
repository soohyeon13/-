package 앱데브매칭2020

private val dx = intArrayOf(0,0,1,1)
private val dy = intArrayOf(0,1,1,0)
class Solution1 {
    fun solution(moves: Array<String>): Int {
        var answer  = 0
        val map = Array(1010){Array(1010){""}}
        val visited = Array(1010){BooleanArray(1010)}
        var startX = 500
        var startY = 500
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
            visited[startX][startY] = true
            map[startX][startY] = moves[i]
        }
        for (i in map.indices) {
            for (j in map[0].indices) {
                if (i+1 <1010 || j+1 <1010) {
                    if (visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]) {
                        val set = HashSet<String>()
                        for (k in 0 until 4) {
                            val nx = i + dx[k]
                            val ny = j + dy[k]
                            set.add(map[nx][ny])
                            println(map[nx][ny])
                        }
                        println(set.toString())
                        if (set.size == 4) answer += 1
                    }
                }
            }
        }
        return answer
    }
}
fun main() {
    val sol = Solution1()
    val arr = arrayOf("U", "U", "R", "D", "L", "L", "L", "U", "R", "D", "D", "D", "L", "U", "R", "R", "R", "D", "L", "U")
    println(sol.solution(arr))
}