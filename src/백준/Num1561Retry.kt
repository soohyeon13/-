package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }
    var left: Long = 0
    var right: Long = 6000000000
    var cnt: Long = 0
    var answer: Long = 0
    if (n <= m) {
        println(n)
    } else {
        while (left <= right) {
            val mid = (left + right) / 2
            cnt = m.toLong()
            for (i in arr.indices) {
                cnt += (mid / arr[i])
            }
            if (cnt >= n) {
                answer = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        cnt = m.toLong()
        for (i in arr.indices) {
            cnt += ((answer - 1) / arr[i])
        }
        for (i in arr.indices) {
            if (answer.toInt() % arr[i] == 0) cnt++
            if (cnt.toInt() == n) {
                println(i + 1)
                break
            }
        }
    }
    bw.flush()
}