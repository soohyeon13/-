package 백준

private lateinit var map : Array<IntArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m,r) = br.readLine().split(" ").map { it.toInt() }
    map = Array(n){ IntArray(m) }
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
        }
    }

}

private fun calRotate(n: Int,m:Int, r : Int) {

}