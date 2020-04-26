package 카카오인턴대비.level3

class Level3WordConvert {
    private lateinit var visited: Array<Boolean>
    private var answer = 0
    fun solution(begin: String, target: String, words: Array<String>): Int {
        visited = Array(words.size) { false }
        dfs(begin, target, words, 0)
        return answer
    }

    private fun dfs(begin: String, target: String, words: Array<String>, conversion: Int) {
        if (begin.equals(target)) {
            answer =
                    if (answer == 0) conversion else answer.coerceAtMost(conversion)
        }
        for (i in words.indices) {
            if (begin.equals(words[i])) continue
            if (!visited[i] && checkOneDiff(begin,words[i])){
                visited[i] = true
                dfs(words[i],target,words,conversion+1)
                visited[i] = false
            }
        }
    }
    private fun checkOneDiff(begin:String,words:String) : Boolean {
        val len = begin.length
        var cnt = 0
        for (i in 0 until len) {
            if (begin[i] != words[i]) {
                cnt++
                if (cnt >1) {
                    break
                }
            }
        }
        return cnt == 1
    }
}