package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val word = br.readLine()
    val value = br.readLine()
    var count = 0
    var index = 0
    var answerCheck = true
    for (i in word.indices) {
        if (word[i] == value[index]) {
            count++
            index++
        }else {
            count = 0
            index = 0
        }
        if (count == value.length) {
            answerCheck =false
            println(1)
            break
        }
    }
    if (answerCheck) println(0)
    bw.flush()
}