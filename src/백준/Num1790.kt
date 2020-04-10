package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    var K = cnt[1].toLong()
    var N = cnt[0].toLong()
    var totalN : Long = 0
    var numCount : Long= 9
    var numLen : Long= 1
    var answer : Long =0
    var a : Long = 1
    while (K > numCount*numLen) {
        totalN += numCount
        K -= numCount*numLen
        numCount *= 10
        numLen +=1
    }
    totalN = (K-1)/numLen +1
    if (totalN > N) println(-1)
    else {
        var temp:Long = (K-1)%numLen+1
        for (i in 0 until numLen-1) a *=10
        for (i in 0 until temp) {
            answer = totalN/a
            totalN %= a
            a /=10
        }
    }
    println(answer)
}