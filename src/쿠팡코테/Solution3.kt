package 쿠팡코테

class Solution3 {
    fun solution(k:Int,score:IntArray) :Int {
        val map = HashMap<Int,HashSet<Int>>()
        for (i in 1 until score.size) {
            val a = score[i-1] - score[i]
            if (!map.containsKey(a)) {
                map[a] = HashSet()
            }
            map[a]?.add(i+1)
        }
        val a = map.filter { it.value.size >=k }.values.flatten()
        var answer = HashSet<Int>()
        for (i in a.indices) {
            answer.add(a[i])
            answer.add(a[i]-1)
        }
        println(answer.toString())
        return score.size-answer.size
    }
}

fun main() {
    val sol = Solution3()
    val a = intArrayOf(1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100)
    println(sol.solution(2,a))
}