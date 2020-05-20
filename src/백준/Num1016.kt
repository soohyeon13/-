package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (min,max) = br.readLine().split(" ").map { it.toLong() }
    val check = BooleanArray((max-min +1).toInt())
    var i : Long= 2
    while (i * i <= max) {
        val p = i*i
        val start = if (min %p == 0.toLong()) min/p else (min/p)+1
        var j = start
        while (p *j <= max) {
            check[((j*p)-min).toInt()] =true
            j++
        }
        i++
    }
    var cnt = 0
    for (i in 0 .. (max-min)) {
        if (!check[i.toInt()]) cnt +=1
    }
    println(cnt)
    bw.flush()
}
