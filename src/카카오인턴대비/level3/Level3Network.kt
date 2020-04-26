package 카카오인턴대비.level3

class Level3Network {
    private lateinit var visited : Array<BooleanArray>
    fun solution(n:Int,computers:Array<IntArray>):Int {
        visited = Array(n){ BooleanArray(n) }
        var answer = 0
        for (i in 0 until n) {
            if (!visited[i][i]) {
                answer++
                dfs(computers,i,n)
            }
        }
        return answer
    }
    private fun dfs(computers: Array<IntArray>, start: Int, n: Int) {
        for (i in 0 until n) {
            if (computers[start][i] == 1 && !visited[start][i]) {
                visited[start][i] =true
                visited[i][start] = true
                dfs(computers,i,n)
            }
        }
    }
}