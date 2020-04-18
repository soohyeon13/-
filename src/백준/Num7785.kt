package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val map = HashMap<String, String>()
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val log = br.readLine().split(" ")
        when(log[1]) {
            "enter" -> {
                map[log[0]] = log[1]
            }
            "leave" -> {
                map.remove(log[0])
            }
        }
    }
    map.toList().sortedByDescending { (key,_) -> key }
            .forEach { println(it.first) }
    bw.flush()
}