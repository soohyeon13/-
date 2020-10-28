package 백준

import kotlin.math.max

private val arr = LongArray(100011)
fun main() {
    val input = System.`in`.bufferedReader()
    val N = input.readLine().toInt()
    val inputArr = input.readLine().split(" ").map { it.toLong() }
    for (i in 1..N) {
        arr[i] = inputArr[i-1]
    }
    val answer = division(1, N)
    println(answer)
}

private fun division(start: Int, end: Int): Long {
    if (start == end) {
        return arr[start] * arr[start]
    }

    val mid = (start + end) / 2
    var result = max(division(start, mid), division(mid + 1, end))
    var min = arr[mid]

    var left = mid
    var right = mid
    var sum = arr[mid]

    while (right - left <= end - start) {
        var leftMinAreaValue = if (left > start) (arr[left-1]+sum) * Math.min(min,arr[left-1]) else -1
        var rightMinAreaValue = if (right < end) (arr[right+1] + sum) * Math.min(min,arr[right+1]) else -1

        if (leftMinAreaValue > rightMinAreaValue ) {
            sum += arr[left-1]
            min = Math.min(min,arr[left-1])
            left--
        } else {
            sum += arr[right+1]
            min = Math.min(min,arr[right+1])
            right++
        }
        result = Math.max(result, min * sum)
    }
    return result
}