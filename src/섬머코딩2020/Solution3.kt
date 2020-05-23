package 섬머코딩2020

private val answer = ArrayList<Int>()
private lateinit var list : Array<Int>
private lateinit var visited : Array<Boolean>
private val path = ArrayList<Int>()
class Solution3 {
    fun solution(total_sp: Int, skills: Array<IntArray>): IntArray {
        list = Array(skills.size +2) {0}
        visited = Array(skills.size +2){ false }
        for (i in skills.indices) {
            find(skills[i][1],skills,1)
            if (!visited[skills[i][0]]) list[skills[i][0]] += list[skills[i][1]]
        }
        val a = total_sp/list.sum()
        for (i in 1 until list.size) {
            answer.add(list[i] * a)
        }
        println(answer.toString())
        println(path.toString())
        return answer.toIntArray()
    }
    private fun find(sk: Int, skills: Array<IntArray>, cnt: Int) : Int {
        for (i in skills.indices) {
            if (skills[i][0] == sk) {
                list[sk] += find(skills[i][1],skills,cnt+1)
                visited[sk] = true
                path.add(sk)
            }
        }
        if (list[sk] == 0)  {
            list[sk] = 1
            path.add(sk)
        }
        return 1
    }
}
fun main() {
    val sol = Solution3()
    val total = 121
    val skills = arrayOf(intArrayOf(1,2), intArrayOf(1,3), intArrayOf(3,6), intArrayOf(3,4), intArrayOf(3,5))
//    val skills = arrayOf(intArrayOf(5,3), intArrayOf(5,2), intArrayOf(2,1), intArrayOf(2,4), intArrayOf(2,6))
    println(sol.solution(total,skills))
}