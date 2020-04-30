package 백준

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var n = br.readLine().toInt()
    var count = 0
    while (true) {
        if (n % 5 == 0) {
            count += n/5
            println("$count")
            break
        }else if (n <= 0) {
            println(-1)
            break
        }
        n -= 3
        count++
    }
    bw.flush()
}