package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val range = br.readLine().split(" ").map { it.toInt() }
    val findArt = Array(range[0]){CharArray(range[1])}
    val art = Array(range[2]){CharArray(range[3])}
    for (i in 0 until range[0]) {
        val row = br.readLine().toCharArray()
        for (j in 0 until range[1]) {
            findArt[i][j] = row[j]
        }
    }
    for (i in 0 until range[2]) {
        val row = br.readLine().toCharArray()
        for (j in 0 until range[3]) {
            art[i][j] = row[j]
        }
    }
    var answer = 0
    for (i in 0 .. (range[2]-range[0])) {
        for (j in 0 .. (range[3]-range[1])) {
            if (art[i][j] == findArt[0][0]) {
                if (check(i,j,findArt,art)) {
                    answer++
                }
            }
        }
    }
    println(answer)
    bw.flush()
}
private fun check(a: Int, b: Int, findArt: Array<CharArray>, art: Array<CharArray>) :Boolean{
    for (i in findArt.indices) {
        for (j in findArt[i].indices) {
            if (art[a+i][b+j] != findArt[i][j]) return false
        }
    }
    return true
}