package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val a = n[0]
    val p = n[1]
    val map = HashMap<Int,Int>()
    var cnt = 1
    map[a] = 0
    var temp = a
    while (true) {
        var d = 0
        while (temp !=0) {
            d += Math.pow((temp%10).toDouble(),p.toDouble()).toInt()
            temp /= 10
        }
        if (map.containsKey(d)) {
            println(map[d])
            break
        }
        map[d] = cnt++
        temp = d
    }
    bw.flush()
}