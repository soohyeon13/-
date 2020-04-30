package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val a = br.readLine().toInt()
        if (a == 0) break
        if (a == 1) println(1)
        else println(find(a))
    }
    bw.flush()
}
private fun find(a :Int) : Int {
    var count = 0
    loop@for (i in a+1 .. 2*a) {
        for (j in 2 .. i/2) {
            if (i%j == 0) continue@loop
        }
        count++
    }
    return count
}