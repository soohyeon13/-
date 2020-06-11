package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (e, s, m) = br.readLine().split(" ").map { it.toInt() }
    var E = 1
    var S = 1
    var M = 1
    for (i in 1..7980) {
        if (E == e && S == s && M == m) {
            println(i)
            break
        }
        E += 1
        S += 1
        M += 1
        if (E == 16) E = 1
        if (S == 29) S = 1
        if (M == 20) M = 1
    }
}