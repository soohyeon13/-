package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    var answer = 0
    val arr = br.readLine().split(" ").map{it.toInt()}
    val primCheck = BooleanArray(1001){true}
    primCheck[1] = false
    for (i in 2 .. 1000) {
        for (j in i+i .. 1000 step i) {
            primCheck[j] = false
        }
    }
    println(primCheck.contentToString())
    for (i in arr.indices) {
        if (primCheck[arr[i]]) answer +=1
    }
    println(answer)
    bw.flush()
}