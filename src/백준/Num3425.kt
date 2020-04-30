package 백준

import java.util.*
import kotlin.collections.ArrayList

private var isERROR = false
private val stack = Stack<Int>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    loop@ while (true) {
        val orders = ArrayList<String>()
        while (true) {
            val order = br.readLine()
            if (order == "QUIT") break@loop
            if (order.isNullOrBlank()) continue@loop
            if (order == "END") break
            orders.add(order)
        }
        val n = br.readLine().toInt()
        for (i in 0 until n) {
            val num = br.readLine().toInt()
            stack.push(num)
            isERROR = false
            for (j in orders.indices) {
                if (isERROR) {
                    break
                }
                val arr = orders[j].split(" ")
                operator(arr)
            }
            if (stack.size != 1 || isERROR) {
                println("ERROR")
                stack.clear()
            } else {
                println(stack.pop())
            }
        }
        println()
    }
    bw.flush()
}

private fun operator(order: List<String>) {
    when (order[0]) {
        "NUM" -> {
            stack.push(order[1].toInt())
        }
        "POP" -> {
            if (isErrorCheck(1)) {
                stack.pop()
            }
        }
        "INV" -> {
            stack.push(stack.pop() * -1)
        }
        "DUP" -> {
            if (isErrorCheck(1)) {
                val copy = stack.peek()
                stack.push(copy)
            }
        }
        "SWP" -> {
            if (isErrorCheck(2)) {
                val first = stack.pop()
                val second = stack.pop()
                stack.push(first)
                stack.push(second)
            }
        }
        "ADD" -> {
            if (isErrorCheck(2)) {
                val first = stack.pop()
                val second = stack.pop()
                val result: Long = (first + second).toLong()
                if (isResultCheck(result)) {
                    stack.push(result.toInt())
                }
            }
        }
        "SUB" -> {
            if (isErrorCheck(2)) {
                val first = stack.pop()
                val second = stack.pop()
                val result: Long = (second - first).toLong()
                if (isResultCheck(result)) {
                    stack.push(result.toInt())
                }
            }
        }
        "MUL" -> {
            if (isErrorCheck(2)) {
                val first = stack.pop()
                val second = stack.pop()
                val result: Long = (second * first).toLong()
                if (isResultCheck(result)) {
                    stack.push(result.toInt())
                }
            }
        }
        "DIV" -> {
            if (isErrorCheck(2)) {
                val first = stack.pop()
                val second = stack.pop()
                val result = second / first
                if (first == 0) {
                    isERROR = true
                } else {
                    val a = if (first > 0) 1 else -1
                    val b = if (second > 0) 1 else -1
                    if (a * b < 0) {
                        stack.push(result * -1)
                    } else {
                        stack.push(result)
                    }
                }
            }
        }
        "MOD" -> {
            if (isErrorCheck(2)) {
                val first = stack.pop()
                val second = stack.pop()
                val result = second % first
                if (first == 0) {
                    isERROR = true
                } else {
                    val b = if (second > 0) 1 else -1
                    stack.push(result * b)
                }
            }
        }
    }
}

private fun isResultCheck(result: Long): Boolean {
    if (Math.abs(result) > Math.pow(10.0, 9.0).toInt()) {
        isERROR = true
        return false
    }
    return true
}

private fun isErrorCheck(n: Int): Boolean {
    if (stack.size < n) {
        isERROR = true
        return false
    }
    return true
}