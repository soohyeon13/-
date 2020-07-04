package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val map = HashMap<String,String>()
    var answer = ""
    for (i in 0 until n) {
        val password = br.readLine()
        val reversPassword = password.reversed()
        if (!map.containsKey(password)) map[password] = password
        else answer = password
        if (!map.containsKey(reversPassword)) map[reversPassword] = reversPassword
        else answer = password
    }
    println("${answer.length} ${answer[answer.length/2]}")
    bw.flush()
}