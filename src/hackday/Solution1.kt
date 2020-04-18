package hackday

class Solution1 {
    fun solution(n: Int, delivery: Array<IntArray>): String {
        val answer = Array<String>(n + 1) { "?" }
        for (i in delivery.indices) {
            val a = delivery[i][0]
            val b = delivery[i][1]
            val c = delivery[i][2]
            if (delivery[i][2] == 1) {
                answer[a] = "O"
                answer[b] = "O"
            } else {
                if (answer[a] == "?" && answer[b] == "?") {
                    answer[a] = "X"
                    answer[b] = "X"
                } else if (answer[a] == "O" && answer[b] == "?") {
                    answer[b] = "X"
                } else if (answer[a] == "?" && answer[b] == "O") {
                    answer[a] = "X"
                }
            }
        }
        val str = StringBuilder()
        for (i in 1 until answer.size) {
            str.append(answer[i])
        }
        return str.toString()
    }
}

fun main() {
    val sol = Solution1()
    val arr = arrayOf(intArrayOf(5, 6, 0),
            intArrayOf(1, 3, 1), intArrayOf(1, 5, 0), intArrayOf(7, 6, 0),
            intArrayOf(3, 7, 1), intArrayOf(2, 5, 0))
    println(sol.solution(7, arr))
}