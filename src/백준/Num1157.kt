package 백준

fun main() {
    val br= System.`in`.bufferedReader()
    val s = br.readLine().toUpperCase().toCharArray().map { it.toInt()-65 }
    val answer = IntArray(30)
    for (i in s.indices) {
        answer[s[i]] = answer[s[i]] +1
    }
    val maxValue = answer.max()!!
    val a = answer.filter { it == maxValue }.count()
    if (a > 1) println("?")
    else {
        val index = answer.indexOf(maxValue) + 65
        println(index.toChar())
    }
}