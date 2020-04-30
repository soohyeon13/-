package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()
    for (i in 0 until m) {
        val order = br.readLine().split(" ").map{it.toInt()}
        var left = order[0]
        var right = order[1]
        var check = true
        while (left != right) {
            if (arr[left-1] != arr[right-1]) {
                check = false
                break
            }
            left++
            right--
        }
        if (check) println(1)
        else println(0)
    }
    bw.flush()
}