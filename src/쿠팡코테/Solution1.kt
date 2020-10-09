package 쿠팡코테

class Solution1 {
    fun solution(N:Int): IntArray{
        var result = IntArray(2)
        var max = 0
        var answer = 0
        for (i in 2 .. 10) {
            var copyN = N
            var sum = 1
            println(i)
            while (true) {
                val a = copyN / i
                val b = copyN % i
                if (a == 0) {
                    if (b != 0) {
                        sum *= b
                    }
                    break
                }
                if (b != 0) sum *= b
                copyN = a
            }
            if (max <= sum) {
                max = sum
                answer = i
            }
        }
        result[0] = answer
        result[1] = max
        return result
    }
}

fun main() {
    val sol = Solution1()
    println(sol.solution(10).contentToString())
    println(sol.solution(14).contentToString())
}