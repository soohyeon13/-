package 카카오인턴2020

import java.util.*

class Solution1 {
    private val sb = StringBuilder()
    private var left = Pad(3,0,-1,0)
    private var right = Pad(3,2,-2,0)
    private val dx = intArrayOf(-1, 0, 1, 0)
    private val dy = intArrayOf(0, 1, 0, -1)
    private lateinit var keypad : Array<IntArray>
    fun solution(numbers: IntArray, hand: String): String {
        keypad = Array(4) { IntArray(3) }
        keypad[3][0] = -1
        keypad[3][1] = 0
        keypad[3][2] = -2
        var num = 1
        for (i in 0 until keypad.size - 1) {
            for (j in 0 until keypad[i].size) {
                keypad[i][j] = num++
            }
        }
        for (i in numbers.indices) {
            when (numbers[i]) {
                1, 4, 7 -> {
                    sb.append("L")
                    val a = findNumIndex(numbers[i])
                    left = Pad(a[0],a[1], numbers[i],0)
                }
                3, 6, 9 -> {
                    sb.append("R")
                    val a =findNumIndex(numbers[i])
                    right = Pad(a[0],a[1],numbers[i],0)
                }
                else -> {
                    if (check("left",numbers[i]) > check("right",numbers[i])) {
                        sb.append("R")
                        val a = findNumIndex(numbers[i])
                        right = Pad(a[0],a[1],numbers[i],0)
                    }else if (check("left",numbers[i]) < check("right",numbers[i])) {
                        sb.append("L")
                        val a = findNumIndex(numbers[i])
                        left = Pad(a[0],a[1],numbers[i],0)
                    }else {
                        if (hand == "left") {
                            sb.append("L")
                            val a = findNumIndex(numbers[i])
                            left = Pad(a[0],a[1],numbers[i],0)
                        }else {
                            sb.append("R")
                            val a = findNumIndex(numbers[i])
                            right = Pad(a[0],a[1],numbers[i],0)
                        }
                    }
                }
            }
        }
        return sb.toString()
    }
    private fun findNumIndex(num : Int) : IntArray {
        val findIndex = IntArray(2)
        for (i in keypad.indices) {
            for (j in keypad[i].indices) {
                if (keypad[i][j] == num) {
                    findIndex[0] = i
                    findIndex[1] = j
                }
            }
        }
        return findIndex
    }
    private fun check(h : String, numb :Int) : Int{
        val queue : Queue<Pad> = LinkedList()
        val visited = Array(keypad.size){BooleanArray(keypad[0].size)}
        if (h == "left") {
            queue.offer(left)
        }else queue.offer(right)
        var cnt = 0
        while (!queue.isEmpty()) {
            val q = queue.poll()
            if (q.num == numb) {
                cnt = q.cnt
                break
            }
            for (i in 0 until 4) {
                val nx = q.x + dx[i]
                val ny = q.y + dy[i]
                if (nx < 0|| ny < 0 || nx >=4 || ny >=3) continue
                if (visited[nx][ny]) continue
                queue.offer(Pad(nx,ny,keypad[nx][ny], q.cnt+1))
                visited[nx][ny] = true
            }
        }
        return cnt
    }
}
private data class Pad (
        val x : Int,
        val y : Int,
        val num : Int,
        val cnt : Int
)