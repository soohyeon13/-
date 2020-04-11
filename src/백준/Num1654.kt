package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val K  = cnt[0].toInt()
    val N = cnt[1].toInt()
    val list = mutableListOf<Int>()
    for (i in 0 until K) {
        val a = br.readLine().toInt()
        list.add(a)
    }
    var left :Long= 1
    var right:Long = list.max()!!.toLong()
    while (left<=right) {
        var mid = (left + right)/2
        var total :Long= 0
        for (i in list.indices) {
            total += list[i]/mid
        }
        if (total >= N) {
            left = mid +1
        }else {
            right = mid -1
        }
    }
    println(right)
    bw.flush()
}