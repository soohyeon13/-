package 쿠팡코테

import java.util.*
import kotlin.math.max
import kotlin.math.min

class Solution2 {
    companion object {
        private val months = arrayOf(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334)
    }
    fun solution(n: Int, customers: Array<String>): Int {
        val a=getTime(customers)
        val kiosks = IntArray(n)
        val result = IntArray(n)
        val queue = PriorityQueue<Int>()
        for (i in a.indices) {
            val time = a[i][0] + a[i][1]

        }
//
//        for (customer in a) {
//            val kiosk = isEmpty(kiosks,customer[0])
//            val willStart = max(kiosks[kiosk],customer[0])
//            result[kiosk]++
//            kiosks[kiosk] = willStart + customer[1]
//        }
        return result.max()!!
    }

    private fun isEmpty(k : IntArray,start:Int):Int {
        var min = Int.MAX_VALUE
        var kiosk = 0
        for (i in k.indices) {
            if (k[i] == 0) {
                return i
            }
            if (min > k[i]) {
                min = k[i]
                kiosk = i
            }
        }
        return kiosk
    }

    private fun getTime(customers: Array<String>) :List<IntArray>{
        return customers.map {
            val split = it.split(" ")
            val date = split[0].split("/")
            val time = split[1].split(":")
            val second = time[2].toInt()
            val minute = time[1].toInt() * 60
            val hour = time[0].toInt() * 60 * 60
            val day = date[1].toInt() * 60 * 60 * 24
            val month = getMonth(date[0].toInt()) * 60 * 60 * 24
            val result = month + day + hour + minute + second
            val shared = split[2].toInt() * 60

            return@map intArrayOf(result, shared)
        }
    }

    private fun getMonth(month: Int) = months[month - 1]
}

fun main() {
    val sol = Solution2()
    println(sol.solution(2, arrayOf("02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01")))
}
private data class Kiosk(
        val time:Int,
        val number:Int
):Comparable<Kiosk> {
    override fun compareTo(other: Kiosk): Int {
        TODO("Not yet implemented")
    }
}
