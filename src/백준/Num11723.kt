package 백준

private var map = Array<Int>(21) {0}
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val row = br.readLine().split(" ")
        when(row[0]) {
            "add" -> {
                add(row[1].toInt())
            }
            "check" ->{
                check(row[1].toInt())
            }
            "remove" -> {
                remove(row[1].toInt())
            }
            "toggle" -> {
                toggle(row[1].toInt())
            }
            "all" -> {
                all()
            }
            "empty" -> {
                empty()
            }
        }
    }
    bw.flush()
}

private fun add(n : Int) {
    if (map[n] == 0) map[n] = 1
}
private fun remove(n : Int) {
    if (map[n] == 1) map[n] =0
}
private fun check(n: Int) {
    println(map[n])
}
private fun toggle(n : Int) {
    if (map[n] == 0) map[n] = 1
    else map[n] = 0
}
private fun all() {
    for (i in 1 ..20) {
        map[i] = 1
    }
}
private fun empty() {
    map = Array(21){0}
}
