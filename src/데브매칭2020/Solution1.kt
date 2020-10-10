package 데브매칭2020

import 쿠팡코테.Solution2
import java.lang.Integer.max
import java.util.*

class Solution1 {

    companion object {
        private val months = arrayOf(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334)
    }

    fun solution(n: Int, customers: Array<String>): Int {
        val convertCustomer = getConvertToSec(customers)
        val queue = PriorityQueue<Order>(Comparator { t: Order, t2: Order ->
            if (t.time > t2.time) 1
            else if (t.time == t2.time) {
                if (t.number > t2.number) 1
                else -1
            }else -1
        })
        for (i in 0 until n) {
            queue.offer(Order(0,i))
        }
        val result = IntArray(n)
        for (customer in convertCustomer) {
            val q = queue.poll()
            val willStart = max(q.time,customer[0])
            result[q.number]++
            queue.offer(Order(willStart+customer[1],q.number))
        }
        return result.max()!!
    }

    private fun getConvertToSec(customers: Array<String>) :List<IntArray>{
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

            return@map intArrayOf(result,shared)
        }
    }

    private fun getMonth(month: Int) = months[month - 1]
}

private data class Order(
        val time:Int,
        val number:Int
)

fun main() {
    val sol = Solution1()
    println(sol.solution(2, arrayOf("02/28 23:59:00 03","03/01 00:00:00 02", "03/01 00:05:00 01")))
}