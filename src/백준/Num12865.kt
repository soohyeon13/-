package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n[0]+1){IntArray(n[1]+1){0} }
    val w = Array(n[0]+1){0}
    val v = Array(n[0]+1){0}
    for (i in 1..n[0]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        w[i] = row[0]
        v[i] = row[1]
    }
    for (i in 1 .. n[0]) {
        for (j in 1 .. n[1]) {
            arr[i][j] = arr[i-1][j]
            if (j - w[i] >= 0) {
                arr[i][j] = Math.max(arr[i-1][j],arr[i-1][j-w[i]]+ v[i])
            }
        }
    }
    println(arr[n[0]][n[1]])
    bw.flush()
}