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
    val distance = IntArray(n[0]+1)// 각각의 노드까지의 최단거리가 저장된다.
    val check = BooleanArray(n[0]+1) // 각각의 노드를 방문했는지 체크
    for (i in 1 until n[0]+1) {
        distance[i] = Int.MAX_VALUE
    }
    distance[v] = 0
    check[v] = true
    for (i in 1 until n[0]+1) {
        if (!check[i] && map[v][i] != 0){
            //시작노드와 연결되어 있는 노드들의 distance값을 갱신
            distance[i] = map[v][i]
        }
    }
    println(distance.contentToString())
    for (i in 0 until n[0]-1) {
        var min = Int.MAX_VALUE
        var minIndex = 1
        for (j in 1 until n[0]+1) {
            if (!check[j] && distance[j] != Int.MAX_VALUE) {
                if (distance[j] < min) {
                    min = distance[j]
                    minIndex = j
                }
            }
        }
        check[minIndex] = true
        for (j in 1 until n[0]+1) {
            if (!check[j] && map[minIndex][j] != 0) {
                if (distance[j] > distance[minIndex] + map[minIndex][j]) {
                    distance[j] = distance[minIndex] + map[minIndex][j]
                }
            }
        }
    }

    for (i in 1 until n[0] +1) {
        if (distance[i] == Int.MAX_VALUE) {
            println("INF")
        }else {
            println(distance[i])
        }
    }
    bw.flush()
}