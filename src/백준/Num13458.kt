package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine()
            .split(" ")
            .map { it.toInt() }
            .toIntArray()
    var answer : Long=0
    val supervisor = br.readLine().split(" ").map { it.toInt() }
    for (i in arr.indices) {
        var people = arr[i]
        if (people - supervisor[0] <0) {
            answer += 1
        }else {
            answer +=1
            people -= supervisor[0]
            var a = people/supervisor[1]
            if (people % supervisor[1] != 0) {
                a +=1
            }
            answer += a
        }
    }
    println(answer)
    bw.flush()
}