package 백준

private lateinit var arr : Array<IntArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    arr = Array(4){IntArray(8)}
    for (i in 0 until 4) {
        val row = br.readLine().toCharArray().map { it.toString().toInt() }
        arr[i] = row.toIntArray()
    }
    val k = br.readLine().toInt()
    for (i in 0 until k) {
        val r = br.readLine().split(" ").map { it.toInt() }
        checkRotate(r[0]-1,r[1])
    }
    var answer = 0
    for (i in 0 until 4) {
        answer += arr[i][0] * Math.pow(2.toDouble(),i.toDouble()).toInt()
    }
    println(answer)
    bw.flush()
}
private fun checkRotate(index : Int, dir: Int) {
    left(index-1,-dir)
    right(index+1,-dir)
    rotate(index,dir)
}
private fun left(index: Int, dir : Int) {
    if (index < 0) return
    if (arr[index][2] != arr[index+1][6]) {
        left(index -1,-dir)
        rotate(index,dir)
    }
}
private fun right(index : Int, dir : Int) {
    if (index > 3) return
    if (arr[index][6] != arr[index-1][2]){
        right(index+1,-dir)
        rotate(index,dir)
    }
}
private fun rotate(index : Int, dir : Int) {
    if (dir ==1) {
        val temp = arr[index][7]
        for (i in 7 downTo 1) {
            arr[index][i] = arr[index][i-1]
        }
        arr[index][0] = temp
    }else {
        val temp = arr[index][0]
        for (i in 0 until 7) {
            arr[index][i] = arr[index][i+1]
        }
        arr[index][7] = temp
    }
}