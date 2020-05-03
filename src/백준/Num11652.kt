package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val map = HashMap<Int,Long>()
    for (i in 0 until n) {
        val num = br.readLine().toInt()
        if (!map.containsKey(num)) map[num] = 1
        else map[num] = map[num]!!.plus(1)
    }
    val a = map.toList().sortedWith(Comparator { t, t2 ->
        if (t.second > t2.second) -1
        else if (t.second == t2.second) {
            if (t.first > t2.first) 1
            else -1
        }
        else 1
    }).first().first
    println(a)
}