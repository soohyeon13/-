package 백준

private val positionList = mutableListOf<Int>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val position = br.readLine().split(" ")
    var sister = position[0].toInt()
    var brother = position[1].toInt()
    var time = 0
    var find = true
    positionList.add(sister)
    if (sister == brother) println(time)
    else {
        while (find) {
            for (i in positionList.indices) {
                findRoot(positionList[i])
            }
            time += 1
            if (positionList.contains(brother)) find = false
        }
        println(time)
    }
    bw.flush()
}

private fun findRoot(position: Int) {
    positionList.add(position - 1)
    positionList.add(position + 1)
    positionList.add(position * 2)
}