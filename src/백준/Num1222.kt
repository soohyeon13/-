package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toLong() }
    var answer : Long =0
    var left : Long= 1
    var right = arr.max()!!.toLong()
    while (left <= right) {
        val mid = (left+right)/2
        var count : Long= 0
        var cnt : Long= 0
        for (i in arr.indices) {
            if (arr[i] < mid) continue
            if (arr[i] % mid ==0.toLong()) {
                count += mid
                cnt++
            }
        }
        if (cnt <2) {
            right = mid -1
        }else {
            left = mid +1
            answer = if (answer < count) count else answer
        }
    }
    println(answer)
    bw.flush()
}