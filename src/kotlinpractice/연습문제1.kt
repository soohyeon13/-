package kotlinpractice

class 연습문제1 {
    fun solution(a: Int, b: Int) : String {
        val dayList = listOf("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")
        val monthList = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

        var sumDay =0
        for (i in 0 until a-1) {
            sumDay += monthList[i]
        }
        val index =(sumDay+b-1)%7
        return dayList[index]
    }
}