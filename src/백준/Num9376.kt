package 백준

private lateinit var arr: Array<Array<String>>
private lateinit var doorArr: Array<Array<Int>>
private var answer = 30000
private val dy = intArrayOf(1,-1,0,0)
private val dx = intArrayOf(0,0,-1,1)
private var m = 0
private var n = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().toInt()
    for (i in 0 until cnt) {
        val size = br.readLine().split(" ")
        m = size[0].toInt()
        n = size[1].toInt()
        arr = Array(m+2) { Array(n+2) { "" } }
        doorArr = Array(m) { Array(n) { 0 } }
        val prisoners = ArrayList<IntArray>()
        for (j in 0 until m) {
            val low = br.readLine().toCharArray()
            for (k in low.indices) {
                arr[j][k] = low[i].toString()
                if (arr[j][k] == "$") prisoners.add(intArrayOf(j, k))
            }
        }
        bfs(prisoners)
        println(answer)
        answer = 0
    }
    bw.flush()
}

private fun bfs(prisoner: ArrayList<IntArray>) {
    for (i in prisoner.indices) {
        checkDoor(prisoner[i][0], prisoner[i][1])
    }
}

private fun checkDoor(x: Int, y: Int) {
    if (arr[x][y] == "#") doorArr[x][y] +=1

}

































