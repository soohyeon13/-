package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val primes = Array(1000000){false}
    for (i in 2 until  1000000) {
        if (primes[i]) continue
        for (j in i+i until 1000000 step i) {
            primes[j] = true
        }
    }
    loop@while (true){
        val n = br.readLine().toInt()
        if (n == 0) break
        for (i in n-3 downTo 3) {
            if (!primes[i] && !primes[n-i]) {
                println("$n = ${n-i} + $i")
                continue@loop
            }
        }
        println("Goldbach's conjecture is wrong.")
    }
    bw.flush()
}