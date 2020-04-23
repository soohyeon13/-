package 카카오인턴대비.level2

import kotlin.math.pow

class Level2NumBaseBall {
    private val set = HashSet<Int>()
    private lateinit var base : Array<IntArray>
    fun solution(baseball: Array<IntArray>) : Int {
        base = baseball.clone()
        val arr = intArrayOf(1,2,3,4,5,6,7,8,9)
        perm(arr,0,3)
        return set.size
    }
    private fun perm(arr: IntArray,depth:Int,r:Int) {
        if (depth == r) {
            number(arr,r)
            return
        }else {
            for (i in depth until arr.size) {
                swap(arr,depth,i)
                perm(arr,depth+1,r)
                swap(arr,depth,i)
            }
        }
    }
    private fun number(arr: IntArray, r: Int) {
        var resultNum : Double= 0.0
        for (i in 0 until r) {
            resultNum += arr[i] * 10.0.pow((r - 1 - i).toDouble())
        }
        check(resultNum.toInt())
    }
    private fun check(result:Int) {
        var isRight = true
        var strike = 0
        var ball = 0
        var numToStr = result.toString()
        for (i in base.indices) {
            val tryBall = base[i][0].toString()
            for (j in 0 until 3) {
                var chr = tryBall[j]
                if (chr == numToStr[j]) strike++
                else if (numToStr.contains(chr))ball++
            }
            if (strike != base[i][1] || ball != base[i][2]) {
                isRight = false
                break
            }
            strike = 0
            ball = 0
        }
        if (isRight) set.add(result)
    }
    private fun swap(arr:IntArray,i:Int,j:Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}