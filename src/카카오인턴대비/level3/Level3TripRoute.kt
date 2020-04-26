package 카카오인턴대비.level3

class Level3TripRoute {
    private val arr = ArrayList<String>()
    private lateinit var visited : Array<Boolean>
    private var route = ""
    fun solution(tickets:Array<Array<String>>) : Array<String> {
        visited = Array(tickets.size){false}
        for (i in tickets.indices) {
            val start = tickets[i][0]
            val end = tickets[i][1]
            if (start == "ICN") {
                visited[i] = true
                route = "${start},"
                dfs(tickets,end,1)
                visited[i] = false
            }
        }
        arr.sort()
        return arr[0].split(",").dropLast(1).toTypedArray()
    }
    private fun dfs(tickets: Array<Array<String>>, end: String, count: Int) {
        route += "${end},"
        if (count == tickets.size) {
            arr.add(route)
            return
        }else {
            for (i in tickets.indices) {
                val nxStart = tickets[i][0]
                val nxEnd = tickets[i][1]
                if (nxStart == end && !visited[i]) {
                    visited[i] = true
                    dfs(tickets,nxEnd,count+1)
                    visited[i] = false
                    route = route.substring(0,route.length-4)
                }
            }
        }
    }
}