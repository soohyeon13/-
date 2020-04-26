package 카카오인턴대비.level3

import java.util.*
class Level3Delivery {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val linkM = HashMap<Int, MutableList<TD>>().apply {
            road.groupBy({ it[0] }, { TD(it[1], it[2]) }).forEach { key, value ->
                put(key, getOrDefault(key, mutableListOf()).apply { addAll(value) })
            }
            road.groupBy({ it[1] }, { TD(it[0], it[2]) }).forEach { key, value ->
                put(key, getOrDefault(key, mutableListOf()).apply { addAll(value) })
            }
        }
        println(linkM)

        val delivery = HashSet<Int>().apply { add(1) }
        val shorts = IntArray(N) { 500001 }.also { it[0] = 0 }
        val nextDT = LinkedList<TD>()

        fun search(td: TD) {
            linkM[td.town]?.asSequence()!!.filter { td.distance + it.distance <= k }.map { TD(it.town, td.distance + it.distance) }.forEach {
                if (shorts[it.town - 1] > it.distance) {
                    shorts[it.town - 1] = it.distance
                    delivery.add(it.town)
                    nextDT.add(it)
                }
            }
        }

        search(TD(1, 0))
        while (nextDT.isNotEmpty()) {
            search(nextDT.pollFirst())
        }

        return delivery.size
    }

    data class TD(var town: Int, var distance: Int)
}