package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val N :Long = cnt[0].toLong()
    val C :Long = cnt[1].toLong()
    val list = mutableListOf<Long>()
    for (i in 0 until N) {
        list.add(br.readLine().toLong())
    }
    list.sort()
    var left: Long = 1
    var right: Long = list.last()-1
    var mid : Long= 0
    while (left <= right) {
        var c = 1
        var prev = list.first()
        mid = (left + right)/2
        for (i in list.indices) {
            if (list[i]-prev >= mid) {
                c += 1
                prev = list[i]
            }
        }
        if (c >= C) left =mid +1
        else right = mid-1
    }
    println(right)
    bw.flush()
}