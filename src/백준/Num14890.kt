package 백준

private lateinit var map : Array<IntArray>
private var rampLen = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().split(" ").map {it.toInt()}
    rampLen = n[1]
    map = Array(n[0]){ IntArray(n[0]) }
    for (i in 0 until n[0]) {
        val row = br.readLine().split(" ").map { it.toInt() }
        for (j in row.indices) {
            map[i][j] = row[j]
        }
    }
    var answer = 0
    for (i in map.indices) {
        if (checkPath(map[i])) answer +=1
        val arr = ArrayList<Int>()
        for (j in map[i].indices) {
            arr.add(map[j][i])
        }
        if (checkPath(arr.toIntArray())) answer +=1
    }
    println(answer)
    bw.flush()
}

private fun checkPath(arr : IntArray) : Boolean {
    var index = 0
    var floor = arr[index]
    var cnt = 1
    while (index < arr.size-1) {
        index++
        if (Math.abs(floor - arr[index]) > 1) return false
        if (floor < arr[index])  {
            if (cnt < rampLen) return false
            cnt = 1
        }else if (floor == arr[index]) {
            cnt +=1
        }else {
            if (index + rampLen <= arr.size) {
                for (i in 0 until rampLen) {
                    if (arr[index] != arr[index+i]) return false
                }
            }else return false
            index = (index+ rampLen-1)
            cnt =0
        }
        floor = arr[index]
    }
    return true
}