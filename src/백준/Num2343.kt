package 백준

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val N = cnt[0].toInt()
    val M = cnt[1].toInt()
    val blueLays = br.readLine().split(" ")
    var left = Integer.MAX_VALUE
    var right = 0
    for (i in blueLays.indices) {
        right += blueLays[i].toInt()
        left = Math.min(left,blueLays[i].toInt())
    }
    var mid = 0
    while (left <= right) {
        var recordTotal = 0
        var count = 0
        mid = (left + right)/2
        for (i in blueLays.indices) {
            if (recordTotal + blueLays[i].toInt() > mid) {
                recordTotal = 0
                count +=1
            }
            recordTotal += blueLays[i].toInt()
        }
        if (recordTotal != 0) count +=1
        if (count <= M) {
            right = mid -1
        }else {
            left = mid +1
        }
    }
    println(left)
    bw.flush()
}