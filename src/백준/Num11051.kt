package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n[0] +1) { IntArray(n[0]+1)}
    for (i in arr.indices) {
        for (j in 0 ..i) {
            if (i == j || j == 0) {
                arr[i][j] = 1
            }else {
                arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]) % 10007
            }
        }
    }
    println(arr[n[0]][n[1]])
    bw.flush()
}