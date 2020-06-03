package 백준

private lateinit var map : Array<IntArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (r,c,t) = br.readLine().split(" ").map{it.toInt()}
    map = Array(r){ IntArray(c) }
    for (i in 0 until r) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
        }
    }
}
private data class Dust(
        val x : Int,
        val y : Int,
        val dust : Int
)