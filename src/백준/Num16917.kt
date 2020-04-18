package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val order = br.readLine().split(" ")
    val A = order[0].toLong()
    val B = order[1].toLong()
    val C = order[2].toLong()
    val X = order[3].toLong()
    val Y = order[4].toLong()
    var answer : Long= 0
    if (A + B < 2* C) {
        answer = (A*X)+ (B*Y)
    }else {
        val minChicken = Math.min(X,Y)
        val maxChicken = Math.max(X,Y)
        val halfChicken = minChicken * (2*C)
        val remain = maxChicken - minChicken
        if (X < Y) {
            if (2*C < B) {
                answer = halfChicken + (2*C) * remain
            }else {
                answer = halfChicken + (B*remain)
            }
        }else {
            if (2*C < A) {
                answer = halfChicken + (2*C) *remain
            }else {
                answer = halfChicken + (A*remain)
            }
        }
    }
    println(answer)
    bw.flush()
}