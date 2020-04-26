package 카카오인턴대비.level3

import java.util.*

class Level3NExpression {
    private var answer = -1
    fun solution(N: Int, number: Int): Int {
        dfs(N,number,0,0)
        return answer
    }
    private fun dfs(N:Int,number:Int,cnt:Int,prev:Int) {
        var temp = N
        if (cnt >8) {
            answer = -1
            return
        }
        if (number == prev) {
            if (answer == -1 || answer > cnt) {
                answer = cnt
                return
            }
        }
        for (i in 0 until 8 -cnt) {
            dfs(N,number,cnt+1 +i,prev + temp)
            dfs(N,number,cnt+1+i,prev-temp)
            dfs(N,number,cnt+1+i,prev*temp)
            dfs(N,number,cnt+1+i,prev/temp)
            temp = convertN(temp,N)
        }
    }
    private fun convertN(value : Int,N:Int) : Int {
        return value *10 +N
    }
}