package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (a,b,v) = br.readLine().split(" ").map { it.toLong() }
    var left : Long= 1
    var right : Long = v
    var answer : Long= 0
    var mid = v/2
    while (true) {
        answer = mid / (a-b)
        if (v - ((a-b) * answer) > a) {
            left = mid
        }else if (v - ((a-b) * answer) == a) {
            break
        }else {
            if(mid + a -v >= (a-b)) {
                right = mid
            }else {
                break
            }
        }
        mid = (left + right)/2
    }
    println(answer+1)
    bw.flush()
}