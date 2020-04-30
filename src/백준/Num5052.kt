package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var n = br.readLine().toInt()
    while (n > 0) {
        val num = br.readLine().toInt()
        val arr = ArrayList<String>()
        for (i in 0 until num) {
            val call = br.readLine()
            arr.add(call)
        }
        arr.sort()
        var check = true
        for (i in 0 until arr.size-1) {
            if (arr[i] < arr[i+1]) {
                val regex = Regex("${arr[i]}(?=.)")
                if (regex.find(arr[i+1]) != null) {
                    check = false
                    break
                }
            }
        }
        if (check) println("YES")
        else println("NO")
        n--
    }
    bw.flush()
}