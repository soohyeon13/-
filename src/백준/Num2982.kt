package 백준

private lateinit var loadInfos : Array<ArrayList<LoadInfo>>
fun main() {
    val input = System.`in`.bufferedReader()
    val (N,M) = input.readLine().split(" ").map { it.toInt() }
    val (A,B,K,G) = input.readLine().split(" ").map { it.toInt() }
    val kingPath = input.readLine().split(" ").map { it.toInt() }.toIntArray()
    loadInfos = Array(N+1) {ArrayList<LoadInfo>()}
    for (i in 0 until M) {
        val row = input.readLine().split(" ").map { it.toInt() }
        loadInfos[row[0]].add(LoadInfo(row[1],row[2]))
        loadInfos[row[1]].add(LoadInfo(row[0],row[2]))
    }
}

private data class LoadInfo(
        val end: Int,
        val time:Int
)