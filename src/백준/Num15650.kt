package 백준

private val answer = ArrayList<String>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n){i -> i+1}
    val visited = Array(n){false}
    comb(arr,visited,0,n,m)
    answer.sort()
    answer.forEach { println(it) }
    bw.flush()
}

private fun comb(arr:Array<Int>,visited : Array<Boolean>,start: Int,n:Int,r:Int){
    if (r == 0) {
        val sb = StringBuilder()
        for (i in visited.indices) {
            if (visited[i]) {
                sb.append(arr[i]).append(" ")
            }
        }
        answer.add(sb.toString())
    }
    for (i in start until n) {
        visited[i] = true
        comb(arr,visited,i+1,n,r-1)
        visited[i] = false
    }
}