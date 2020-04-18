package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ")
    val arr = HashMap<String,String>()
    val answer = HashMap<String,String>()
    for (i in 0 until n[0].toInt()) {
        val name = br.readLine()
        arr[name] = name
    }
    for (i in 0 until n[1].toInt()) {
        val name = br.readLine()
        if (arr.containsKey(name)) answer[name] = name
    }
    println(answer.size)
    answer.toList().sortedBy { (value) -> value }.forEach { println(it.first) }
    bw.flush()
}