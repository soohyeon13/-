package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val first = br.readLine().split(" ")
    val second = br.readLine().split(" ")
    val totalCnt = cnt[0].toInt() + cnt[1].toInt()
    var firstCnt = 0
    var secondCnt = 0
    var answer = StringBuilder()
    for (i in 0 until totalCnt) {
        if (firstCnt >= cnt[0].toInt()) {
            answer.append(second[secondCnt] + " ")
            secondCnt += 1
            continue
        }
        if (secondCnt >= cnt[1].toInt()) {
            answer.append(first[firstCnt] + " ")
            firstCnt += 1
            continue
        }
        if (first[firstCnt].toInt() > second[secondCnt].toInt()) {
            answer.append(second[secondCnt] + " ")
            secondCnt += 1
        } else {
            answer.append(first[firstCnt] + " ")
            firstCnt += 1
        }
    }
    println(answer.trim())
    bw.flush()
}