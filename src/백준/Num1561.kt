package 백준

private var N = 0
private var M = 0
private var answer: Long = 0
private lateinit var arr: Array<Int>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    N = n[0]
    M = n[1]
    arr = Array(M) { 0 }
    val list = br.readLine().split(" ").map { it.toInt() }
    for (i in list.indices) {
        arr[i] = list[i]
    }
    binarySearch()
    val time = answer - 1
    var remain = M.toLong()
    for (i in arr.indices) {
        remain += time / arr[i]
    }
    var index = 0
    while (true) {
        if ((time+1)/arr[index] != (time/arr[index])) {
            remain ++
        }
        index++
        if (remain.toInt() == N) break
    }
    println(index)
    bw.flush()
}

private fun binarySearch() {
    var left: Long = 0
    var right: Long = 60000000000
    while (left <= right) {
        var mid = (left + right) / 2
        var sum: Long = M.toLong()
        for (i in arr.indices) {
            sum += mid / arr[i]
        }
        if (sum >= N) {
            answer = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
}
