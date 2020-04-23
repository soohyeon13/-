package 카카오인턴대비.level2

import kotlin.math.max
import kotlin.math.min

class Level2Square {
    fun solution(w:Int,h:Int):Long {
        val gcdNum = gcd(max(w,h), min(w,h))
        val full : Long = w.toLong()*h.toLong()
        return full - (w.toLong()-h.toLong() + gcdNum.toLong())
    }
    private fun gcd(a:Int,b:Int) : Int {
        return if (b == 0) a else gcd(b,a%b)
    }
}