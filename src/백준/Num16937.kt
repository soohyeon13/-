package 백준

import kotlin.math.max

private var answer = 0
fun main() {
    val input = System.`in`.bufferedReader()
    val (H, W) = input.readLine().split(" ").map { it.toInt() }
    val N = input.readLine().toInt()
    val sticker = Array(N) { IntArray(2) }
    for (i in 0 until N) {
        val row = input.readLine().split(" ").map { it.toInt() }
        sticker[i][0] = row[0]
        sticker[i][1] = row[1]
    }
    var firstWidth = 0
    var firstHeight = 0
    var secondWidth = 0
    var secondHeight = 0
    for (i in 0 until N - 1) {
        firstWidth = sticker[i][0]
        firstHeight = sticker[i][1]
        val firstSize = firstWidth * firstHeight
        for (j in i + 1 until N) {
            secondWidth = sticker[j][0]
            secondHeight = sticker[j][1]
            val secondSize = secondWidth * secondHeight
            if (isCheckSticker(firstWidth, firstHeight, H, W)) {
                if (isCheckSticker(secondWidth, secondHeight, H - firstWidth, W) ||
                        isCheckSticker(secondWidth, secondHeight, H, W - firstHeight)) {
                    maxCalculate(firstSize, secondSize)
                    continue
                }
                if (isCheckSticker(secondHeight, secondWidth, H - firstWidth, W) ||
                        isCheckSticker(secondHeight, secondWidth, H, W - firstHeight)) {
                    maxCalculate(firstSize, secondSize)
                    continue
                }
            }

            if (isCheckSticker(firstHeight, firstWidth, H, W)) {
                if (isCheckSticker(secondWidth, secondHeight, H - firstHeight, W) ||
                        isCheckSticker(secondWidth, secondHeight, H, W - firstWidth)) {
                    maxCalculate(firstSize, secondSize)
                    continue
                }
                if (isCheckSticker(secondHeight, secondWidth, H - firstHeight, W) ||
                        isCheckSticker(secondHeight, secondWidth, H, W - firstWidth)) {
                    maxCalculate(firstSize, secondSize)
                    continue
                }
            }
        }
    }
    println(answer)
}

private fun maxCalculate(first: Int, second: Int) {
    answer = max(answer, first * second)
}

private fun isCheckSticker(width: Int, height: Int, h: Int, w: Int): Boolean {
    return width <= h && height <= w
}