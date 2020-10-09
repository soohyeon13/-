package 쿠팡코테

class Solution4 {
    private var cnt = 0
    private var first = 0
    private var second = 0
    private val map = HashMap<String, ArrayList<String>>()
    fun solution(depar: String, hub: String, dest: String, roads: Array<Array<String>>): Int {
        for (i in roads.indices) {
            if (!map.containsKey(roads[i][0])) {
                map[roads[i][0]] = ArrayList<String>()
            }
            map[roads[i][0]]?.add(roads[i][1])
        }
        println(map.toString())
        dfs(depar, hub)
        println("++++++++")
        first = cnt
        cnt = 0
        dfs(hub, dest)
        second = cnt
        println(first)
        println(second)
        return first * second
    }

    private fun dfs(start: String, des: String) {
        println("start :$start des $des")
        if (start == des) {
            cnt += 1
            return
        }
        if (map.containsKey(start)){
            for (i in map[start]!!.indices) {
                println(map[start].toString())
                dfs(map[start]!![i], des)
            }
        }
    }
}

fun main() {
    val sol = Solution4()
    val a = "SEOUL"
    val b = "DAEGU"
    val c = "YEOSU"
    val d = arrayOf(arrayOf("ULSAN", "BUSAN"),
            arrayOf("DAEJEON", "ULSAN"),
            arrayOf("DAEJEON", "GWANGJU"),
            arrayOf("SEOUL", "DAEJEON"),
            arrayOf("SEOUL", "ULSAN"),
            arrayOf("DAEJEON", "DAEGU"),
            arrayOf("GWANGJU", "BUSAN"),
            arrayOf("DAEGU","GWANGJU"),
            arrayOf("ULSAN","DAEGU"),
            arrayOf("DAEGU", "BUSAN"),
            arrayOf("GWANGJU", "YEOSU"),
            arrayOf("BUSAN", "YEOSU"))
    println(sol.solution(a,b,c,d))
}