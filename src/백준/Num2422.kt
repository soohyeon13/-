package 백준

private lateinit var map : Array<BooleanArray>
private var answer =0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    map = Array(n+1){ BooleanArray(n+1) }
    val visited = BooleanArray(n+1)
    for (i in 0 until m) {
        val row = br.readLine().split(" ").map { it.toInt() }
        map[row[0]][row[1]] = true
        map[row[1]][row[0]] = true
    }
    comb(visited,n,1,0)
    println(answer)
    bw.flush()
}

private fun comb(visited : BooleanArray,n : Int,start:Int, depth : Int) {
    if (depth == 3) {
        val arr = ArrayList<Int>(3)
        for (i in 1 until visited.size) {
            if (visited[i]) arr.add(i)
        }
        if (map[arr[0]][arr[1]]) return
        if (map[arr[0]][arr[2]]) return
        if (map[arr[1]][arr[2]]) return
        answer +=1
        return
    }
    for (i in start ..n) {
        visited[i] = true
        comb(visited,n,i+1,depth+1)
        visited[i] = false
    }
}
