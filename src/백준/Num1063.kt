package 백준

import kotlin.math.abs
import kotlin.math.absoluteValue


private val orderMap = ArrayList<String>()
fun main() {
    val input = System.`in`.bufferedReader()
    val (K, S, N) = input.readLine().split(" ")
    val a = K.toCharArray()
    val b = S.toCharArray()
    var kingX = abs((a[1].toString().toInt() - 9))
    var kingY = (a[0] - 64).toInt()
    var stoneX = abs((b[1].toString().toInt() - 9))
    var stoneY = (b[0] - 64).toInt()

    for (i in 0 until N.toInt()) {
        val order = input.readLine()
        orderMap.add(order)
    }

    for (i in orderMap.indices) {
        val c = orderMap[i].toCharArray()
        var x = 0
        var y = 0
        for (j in c.indices) {
            when (c[j]) {
                'R' -> y += 1
                'L' -> y -= 1
                'B' -> x += 1
                'T' -> x -= 1
            }
        }
        if (isCheckRange(kingX + x, kingY + y)) {
            if (!isCheckStone(kingX + x, kingY + y, stoneX, stoneY)) {
                if (isCheckRange(stoneX+x,stoneY+y)) {
                    stoneX += x
                    stoneY += y
                }else {
                    continue
                }
            }
            kingX += x
            kingY += y
        }
    }

    val king = StringBuilder()
    king.append(kingY.toChar() + 64).append(abs(kingX - 9))
    val stone = StringBuilder()
    stone.append(stoneY.toChar() + 64).append(abs(stoneX - 9))
    println(king.toString())
    println(stone.toString())
}

private fun isCheckRange(x: Int, y: Int): Boolean {
    return !(x < 1 || y < 1 || x > 8 || y > 8)
}

private fun isCheckStone(x: Int, y: Int, sx: Int, sy: Int): Boolean {
    return !(x == sx && y == sy)
}