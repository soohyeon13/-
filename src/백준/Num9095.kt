package 백준

private var answer = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val n =br.readLine().toInt()
        dfs(0,n)
        println(answer)
        answer = 0
    }
}
private fun dfs(sum : Int,n: Int) {
    if (sum == n) {
        answer +=1
        return
    }
    if (sum >n) return
    dfs(sum+1,n)
    dfs(sum+2,n)
    dfs(sum+3,n)
}