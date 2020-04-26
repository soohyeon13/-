package statge3

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class TripRoute {
    private lateinit var visit : Array<Boolean>
    private val list = ArrayList<String>()
    private var route = ""
    fun solution(tickets: Array<Array<String>>): Array<String> {
        visit = Array(tickets.size){false}
        for (i in tickets.indices) {
            val departure = tickets[i][0]
            val destination = tickets[i][1]
            if (departure == "ICN") {
                visit[i] = true
                route = "${departure},"
                dfs(tickets,destination,1)
                visit[i] = false
            }
        }
        list.sort()
        val answer = list[0].split(",").dropLast(1)
        return answer.toTypedArray()
    }
    private fun dfs(tickets: Array<Array<String>>, end: String, count : Int) {
        route += "${end},"
        if (count == tickets.size) {
            list.add(route)
            return
        }
        for (i in tickets.indices) {
            val depart = tickets[i][0]
            val desti = tickets[i][1]
            if (end == depart && !visit[i]) {
                visit[i] = true
                dfs(tickets,desti, count+1)
                visit[i] = false
                route = route.substring(0,route.length-4)
                println(route)
            }
        }
    }
}