package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val N = cnt[0].toInt()
    val S = cnt[1].toLong()
    val arr = ArrayList<Int>()
    val list = br.readLine().split(" ")
    for (i in list.indices) {
        arr.add(list[i].toInt())
    }
    var low = 0
    var high = 0
    var sum : Long = 0
    var size = 1000001
    while (true) {
        if (sum >= S) {
            sum -= arr[low++]
            size = Math.min(size,(high-low)+1)
        }else if (high== N) break
        else {
            sum += arr[high++]
        }
    }
    if (size == 1000001) size = 0
    println(size)
    bw.flush()
}