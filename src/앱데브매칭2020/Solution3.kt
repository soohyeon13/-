package 앱데브매칭2020

class Solution3 {
    fun solution(command: String, buttons: Array<String>, scores: IntArray): Int {
        var answer = command.length
        for (i in buttons.indices) {
            var comm = command
            var score = 0
            for (j in i until buttons.size) {
                if (comm.contains(buttons[j])) {
                    comm = comm.replace(buttons[j], "")
                    score += scores[j]
                }
            }
            if (comm.isNotEmpty()) score += comm.length
            if (answer < score) answer = score
        }
        return answer
    }
}