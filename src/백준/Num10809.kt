package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val s = br.readLine().toCharArray().map { it.toInt()-97 }
    val answer = IntArray(26){-1}
    for (i in s.indices) {
        if (answer[s[i]] == -1) answer[s[i]] = i
    }
    println(answer.joinToString(separator = " "))
    bw.flush()
}