package 백준

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map{it.toInt()}
    val arr = br.readLine().split(" ").map{it.toInt()}
    val answer = n[1]
    var save = 0
    for (i in 0 until arr.size-2) {
        for (j in i+1 until arr.size-1) {
            for (k in j+1 until arr.size) {
                val blackJack = arr[i] + arr[j] + arr[k]
                if (blackJack <= answer) {
                    if (blackJack >save) {
                        save = blackJack
                    }
                }
            }
        }
    }
    println(save)
    bw.flush()
}