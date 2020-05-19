package 백준

private lateinit var durability: Array<Int>
private lateinit var weight: Array<Int>
private var answer = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    durability = Array(n) { 0 }
    weight = Array(n) { 0 }
    for (i in 0 until n) {
        val (s, w) = br.readLine().split(" ").map { it.toInt() }
        durability[i] = s
        weight[i] = w
    }
    dfs(0,n)
    println(answer)
}

private fun dfs(hand: Int, n: Int) {
    if (hand == n) {
        var cnt = 0
        for (i in 0 until n) {
            if (durability[i] <=0) cnt +=1
        }
        if (answer < cnt) answer = cnt
        return
    }
    if (durability[hand] <= 0) dfs(hand + 1, n)
    else {
        var check = false
        for (i in 0 until n) {
            if (i == hand || durability[i] <= 0) continue
            check = true
            durability[i] -= weight[hand]
            durability[hand] -= weight[i]
            dfs(hand + 1, n)
            durability[i] += weight[hand]
            durability[hand] += weight[i]
        }
        if (!check) dfs(hand + 1, n)
    }
}