package 카카오인턴대비.level2

import kotlin.text.StringBuilder

class Level2JadenCase {
    fun solution(s: String): String {
        val str = StringBuilder()
        val arr = s.split(" ")
        for (i in arr.indices) {
            if (arr[i] == " ") {
                str.append(" ")
            }else {
                val first = arr[i][0].toUpperCase()
                val second = arr[i].substring(1,arr[i].length).toLowerCase()
                str.append(first).append(second).append(" ")
            }
        }
        return str.trim().toString()
    }
}