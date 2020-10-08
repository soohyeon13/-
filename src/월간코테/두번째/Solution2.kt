package 월간코테.두번째

import java.lang.Math.pow
import kotlin.math.ln
import kotlin.math.sqrt

private val answer = IntArray(2)
class Solution2 {
    fun solution(arr: Array<IntArray>): IntArray {
        division(arr)
        return answer
    }

    private fun division(arr:Array<IntArray>) {
        if (arr.size == 1) {
            if (arr[0][0] == 1) answer[1] +=1
            else answer[0] +=1
            return
        }
        var cnt = arr[0][0]
        var flag = true
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (arr[i][j] != cnt) flag = false
            }
        }

        if (flag) {
            answer[cnt] +=1
            return
        }

        val size = arr.size/2
        val one = getArray(0,0,arr,size)
        division(one)
        val two = getArray(0,size,arr,size)
        division(two)
        val three = getArray(size,0,arr,size)
        division(three)
        val four =  getArray(size,size,arr,size)
        division(four)
    }

    private fun getArray(x:Int,y:Int,arr:Array<IntArray>,n:Int):Array<IntArray> {
        val copyArr = Array(n){IntArray(n)}
        for (i in 0 until n) {
            for (j in 0 until n) {
                copyArr[i][j] = arr[i+x][j+y]
            }
        }
        return copyArr
    }
}