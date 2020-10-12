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
    numbers = input.readLine().split(" ").map { it.toInt() }.toIntArray()
    operators = input.readLine().split(" ").map { it.toInt() }.toIntArray()
    dfs(1, numbers[0])
    println(maxValue)
    println(minValue)
}

private fun dfs(index: Int, sum: Int) {
    if (index == n) {
        maxValue = max(maxValue, sum)
        minValue = min(minValue, sum)
        return
    }
    //더하기
    if (operators[0] != 0) {
        operators[0] -= 1
        val nSum = sum + numbers[index]
        dfs(index + 1, nSum)
        operators[0] += 1
    }
    //빼기
    if (operators[1] != 0) {
        operators[1] -= 1
        val nSum = sum - numbers[index]
        dfs(index + 1, nSum)
        operators[1] += 1
    }
    //곱하기
    if (operators[2] != 0) {
        operators[2] -= 1
        val nSum = sum * numbers[index]
        dfs(index + 1, nSum)
        operators[2] += 1
    }
    //나누기
    if (operators[3] != 0) {
        operators[3] -= 1
        if (sum < 0) {
            val nSum = ((sum * -1) / numbers[index]) * -1
            dfs(index + 1, nSum)
        } else {
            val nSum = sum / numbers[index]
            dfs(index + 1, nSum)
        }
        operators[3] += 1
    }
}