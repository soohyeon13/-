package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    val m = br.readLine().toInt()
    val find = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    arr.sort()
    var sb = StringBuilder()
    for (i in find.indices) {
        var left = 0
        var right = n-1
        var check = true
        while (left <= right) {
            val mid = (left + right)/2
            if (find[i] == arr[mid]) {
                sb.append("1").append(" ")
                check = false
                break
            }
            if (find[i] > arr[mid]) {
                left = mid +1
            }else {
                right = mid-1
            }
        }
        if (check) sb.append("0").append(" ")
    }
    println(sb.toString().trim())
    bw.flush()
}