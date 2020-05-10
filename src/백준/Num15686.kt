package 백준

private lateinit var a : Array<ArrayList<Chicken>>
private var cnt =0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val chicken = ArrayList<Chicken>()
    val map = Array(n){IntArray(n)}
    for (i in 0 until n) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            if (row[j] == 2) chicken.add(Chicken(i,j))
            map[i][j] = row[j]
        }
    }
    val visited = Array(chicken.size){false}
    a = Array(100){ArrayList<Chicken>() }
    comb(chicken,visited,0,n,m)
    println(a)
}
private data class Chicken(
        val x : Int,
        val y : Int
)

private fun comb(arr : ArrayList<Chicken>,visited : Array<Boolean>,start : Int, n: Int, r: Int) {
    if (r== 0) {
        for (i in visited.indices){
            if (visited[i]) {
                a[cnt++].add(arr[i])
            }
        }
        return
    }
    for (i in start until n) {
        visited[i] = true
        comb(arr,visited,i+1,n,r-1)
        visited[i] = false
    }
}
