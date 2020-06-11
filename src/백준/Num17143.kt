package 백준


private lateinit var map : Array<IntArray>
private val sharks = ArrayList<Shark>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (r,c,m) = br.readLine().split(" ").map { it.toInt() }
    map = Array(r+1){ IntArray(c+2) }
    var manPosition = 0
    var index = 0
    for (i in 0 until m) {
        val row = br.readLine().split(" ").map{it.toInt()}
        map[row[0]][row[1]] = row[4]
        sharks.add(Shark(index++,row[0],row[1],row[2],row[3],row[4]))
    }
    while (manPosition < c+1) {
        manPosition +=1
        for (i in 1 until map.size) {
            if (map[i][manPosition] >0) {
                
            }
        }
    }
}
private data class Shark(
        val index : Int,
        val x : Int,
        val y : Int,
        val speed : Int,
        val dir : Int,
        val size : Int
)