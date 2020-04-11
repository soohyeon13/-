package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val N = cnt[0].toLong()
    val M = cnt[1].toLong()
    val list = mutableListOf<Long>()
    val tress = br.readLine().split(" ")
    for (i in tress.indices) {
        list.add(tress[i].toLong())
    }
    var left : Long = 1
    var right : Long = list.max()!!
    var mid: Long =0
    while (left <= right) {
        var totalTree : Long = 0
        mid = (left+right)/2
        for (i in list.indices) {
            if (list[i] -mid > 0) totalTree += (list[i]-mid)
        }
        if (totalTree >= M) {
            left = mid +1
        }else {
            right = mid-1
        }
    }
    println(right)
    bw.flush()
}