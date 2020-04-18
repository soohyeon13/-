package hackday

class Solution2 {
    fun solution(id_list: Array<String>, k: Int): Int {
        val map = HashMap<String, Int>()
        val dayList = mutableListOf<String>()
        var answer = 0
        for (i in id_list.indices) {
            val dayIds = id_list[i].split(" ")
            for (j in dayIds.indices) {
                if (!map.containsKey(dayIds[j])) {
                    map[dayIds[j]] = 1
                    answer +=1
                } else {
                    if (!dayList.contains(dayIds[j]) && map[dayIds[j]]!! < k) {
                        answer +=1
                        map[dayIds[j]] = map[dayIds[j]]!! +1
                    }
                }
                dayList.add(dayIds[j])
            }
            dayList.clear()
        }
        return answer
    }
}

fun main() {
    val sol = Solution2()
    val arr = arrayOf("JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY")
    println(sol.solution(arr,3))
}