package 월간코테.두번째

class Solution1 {
    fun solution(n: Int): Int {
        var answer = 0
        val sb = StringBuilder()
        var copyN = n
        while (true) {
            val a = copyN / 3
            val b = copyN % 3
            if (a ==0){
                sb.append(b)
                break
            }
            sb.append(b)
            copyN = a
        }
        var squared = 1 // 3의 0 승
        for (i in sb.length-1 downTo 0) {
            answer += sb[i].toString().toInt() * squared
            squared *=3
        }
        return answer
    }
}