package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine()
            .split(" ")
            .map { it.toInt() }
            .toTypedArray()
    val copyArr = arr.clone()
    for (i in 1 until n[0]) {
        arr[i] += arr[i-1]
    }
    for (i in 0 until n[1]) {
        val a = br.readLine().split(" ").map { it.toInt() }
        val answer = arr[a[1]-1] - arr[a[0]-1] + copyArr[a[0]-1]
        println(answer)
    }
    bw.flush()
}