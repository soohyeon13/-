package 백준

fun main() {
    val br =System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val A = br.readLine().toInt()
    val B = br.readLine().toInt()
    val C = br.readLine().toInt()
    val map = HashMap<String,Int>()
    val answer = (A*B*C).toString()
    for (i in 0 .. 9) {
        map[i.toString()] = 0
    }
    for (i in 0 until answer.length) {
        map[answer[i].toString()] = map[answer[i].toString()]!!.plus(1)
    }
    for (i in 0..9) {
        println(map[i.toString()])
    }
    bw.flush()
}