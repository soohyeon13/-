package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val arr = ArrayList<Int>()
    var low =0
    var high = 0
    var answer = 0
    val makeSum = cnt[1].toLong()
    var sum : Long= 0
    val list = br.readLine().split(" ")
    for (i in list.indices) {
        arr.add(list[i].toInt())
    }
    while (true) {
        if (sum >= makeSum) sum -= arr[low++]
        else if (high == cnt[0].toInt()) break
        else sum += arr[high++]
        if (sum == makeSum) answer +=1
    }
    println(answer)
    bw.flush()
}