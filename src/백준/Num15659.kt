package 백준

import kotlin.math.max
import kotlin.math.min

private lateinit var numbers: IntArray
private lateinit var operators: IntArray
private var n = 0
private var maxValue = Int.MIN_VALUE
private var minValue = Int.MAX_VALUE
fun main() {
    val input = System.`in`.bufferedReader()
    val N = input.readLine().toInt()
    n = N
    numbers = input
            .readLine()
            .split(" ")
            .map { it.toInt() }
            .toIntArray()
    operators = input
            .readLine()
            .split(" ")
            .map { it.toInt() }
            .toIntArray()
    val op = mutableListOf(numbers[0].toString())
    dfs(op, 1)
    println(maxValue)
    println(minValue)
}

private fun dfs(operate: MutableList<String>, index: Int) {
    if (operate.size == n + n - 1) {
        val arr = operate.toCollection(ArrayList<String>())
        loop@ while (true) {
            for (i in arr.indices) {
                var sum = 0
                if (arr[i] == "/" || arr[i] == "*") {
                    if (arr[i] == "/") {
                        val first = arr[i - 1].toInt()
                        if (first < 0) {
                            sum = ((first * -1) / arr[i + 1].toInt()) * 1
                        } else {
                            sum = first / arr[i + 1].toInt()
                        }
                    }
                    if (arr[i] == "*") {
                        sum = arr[i - 1].toInt() * arr[i + 1].toInt()
                    }
                    arr.removeAt(i-1)
                    arr.removeAt(i-1)
                    arr.removeAt(i-1)
                    arr.add(i-1,sum.toString())
                    continue@loop
                }
            }
            break
        }
        var sum = arr[0].toInt()
        for (i in arr.indices) {
            if (arr[i] == "+") {
                sum += arr[i + 1].toInt()
            } else if (arr[i] == "-") {
                sum -= arr[i + 1].toInt()
            }
        }
        maxValue = max(maxValue, sum)
        minValue = min(minValue, sum)
        return
    }

    //더하기
    if (operators[0] != 0) {
        operators[0] -= 1
        val expression = mutableListOf<String>()
        expression.addAll(operate)
        expression.add("+")
        expression.add("${numbers[index]}")
        dfs(expression, index + 1)
        operators[0] += 1
    }
    //빼기
    if (operators[1] != 0) {
        operators[1] -= 1
        val expression = mutableListOf<String>()
        expression.addAll(operate)
        expression.add("-")
        expression.add("${numbers[index]}")
        dfs(expression, index + 1)
        operators[1] += 1
    }
    //곱하기
    if (operators[2] != 0) {
        operators[2] -= 1
        val expression = mutableListOf<String>()
        expression.addAll(operate)
        expression.add("*")
        expression.add("${numbers[index]}")
        dfs(expression, index + 1)
        operators[2] += 1
    }
    //나누기
    if (operators[3] != 0) {
        operators[3] -= 1
        val expression = mutableListOf<String>()
        expression.addAll(operate)
        expression.add("/")
        expression.add("${numbers[index]}")
        dfs(expression, index + 1)
        operators[3] += 1
    }
}