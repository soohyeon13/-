package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map { it.toInt() }
    val v = br.readLine().toInt()
    val map = Array(n[0]+1) { IntArray(n[0]+1) { 0 } }
    for (i in 0 until n[1]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        map[row[0]][row[1]] = row[2]
    }
    val distance = IntArray(n[0]+1)
    val check = BooleanArray(n[0]+1)
    for (i in 1 until n[0]+1) {
        distance[i] = Int.MAX_VALUE
    }
    distance[v] = 0
    check[v] = true
    for (i in 1 until n[0]+1) {
        if (!check[i] && map[v][i] != 0){
            distance[i] = map[v][i]
        }
    }
    for (i in 0 until n[0]-1) {
        var min = Int.MAX_VALUE
        var minIndex = 1
        for (j in 1 until n[0]+1) {
            if (!check[j] && distance[j] != Int.MAX_VALUE) {
                println("j:$j")
                if (distance[j] < min) {
                    min = distance[j]
                    minIndex = i
                }
            }
        }
        println("min : $min minIndex : $minIndex")
        check[minIndex] = true
        for (j in 1 until n[0]+1) {
            if (!check[j] && map[minIndex][j] != 0) {
                if (distance[j] > distance[minIndex] + map[minIndex][j]) {
                    println("distance :${distance[j]} minIndex : ${distance[minIndex]} ${map[minIndex][j]}")
                    distance[j] = distance[minIndex] + map[minIndex][j]
                }
            }
        }
    }

    for (i in 1 until n[0] +1) {
        println(distance[i])
    }
    bw.flush()
}