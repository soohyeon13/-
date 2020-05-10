package 카카오인턴2020

import java.util.*
import kotlin.collections.ArrayList

class Solution2 {
    private val operation = Array(6) { ArrayList<String>() }
    private var index = 0
    fun solution(expression: String): Long {
        val exp = expression.toCharArray()
        val operArr = arrayOf("*", "-", "+")
        perm(operArr, 0, 3, 3)
        val sb = StringBuilder()
        val arr = ArrayList<String>()
        for (i in exp.indices) {
            if (exp[i].toInt() in 48..57) {
                sb.append(exp[i].toString())
            } else {
                arr.add(sb.toString())
                arr.add(exp[i].toString())
                sb.setLength(0)
            }
        }
        arr.add(sb.toString())
        var answer: Long = 0
        for (i in operation.indices) {
            val copy = LinkedList<String>()
            for (t in arr.indices) copy.add(arr[t])

            go@ for (j in operation[i].indices) {
                loop@ while (true) {
                    if (copy.size == 1) break
                    for (k in 0 until copy.size - 1) {
                        if (copy[k + 1] == operation[i][j]) {
                            val sum = calculation(copy[k].toLong(), copy[k + 2].toLong(), copy[k + 1])
                            copy.removeAt(k)
                            copy.removeAt(k)
                            copy.removeAt(k)
                            copy.add(k, sum.toString())
                            continue@loop
                        }
                    }
                    continue@go
                }
            }
            val abs = Math.abs(copy[0].toLong())
            answer = if (answer < abs) abs else answer
        }
        return answer
    }

    private fun calculation(a: Long, b: Long, op: String): Long {
        var sum: Long = 0
        when (op) {
            "*" -> {
                sum = a * b
            }
            "-" -> {
                sum = a - b
            }
            "+" -> {
                sum = a + b
            }
        }
        return sum
    }

    private fun swap(arr: Array<String>, depth: Int, i: Int) {
        val temp = arr[depth]
        arr[depth] = arr[i]
        arr[i] = temp
    }

    private fun perm(arr: Array<String>, depth: Int, n: Int, r: Int) {
        if (r == depth) {
            for (i in arr.indices) {
                operation[index].add(arr[i])
            }
            index++
            return
        }
        for (i in depth until n) {
            swap(arr, depth, i)
            perm(arr, depth + 1, n, r)
            swap(arr, depth, i)
        }
    }
}

fun main() {
    val sol = Solution2()
    val exp = "50*6-3*2"
    println(sol.solution(exp))
}
