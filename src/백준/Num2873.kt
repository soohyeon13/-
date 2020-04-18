package 백준

private val a = StringBuilder()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val m = cnt[0].toInt()
    val n = cnt[1].toInt()
    val arr = Array(m){IntArray(n)}
    for (i in 0 until m) {
        val t = br.readLine().split(" ")
        for (j in 0 until n) {
            arr[i][j] = t[j].toInt()
        }
    }
    if (m % 2 == 1 && n % 2 == 1) fullSearch(m, n,0)
    else if (m % 2 == 0) {
        if (n % 2 == 1) {
            search(m,n)
        } else if (n % 2 == 0) {
            anotherSearch(m,n,arr)
        }
    }
    println(a.toString())
}

private fun anotherSearch(m: Int, n: Int, arr: Array<IntArray>) {
    if (arr[0][1] >= arr[1][0]) {
        a.append("R")
        for(i in 0 until n/2 -1) a.append("DRUR")
        a.append("D")
        a.append("D")
        for (i in 0 until n-1) a.append("L")
        a.append("D")
        fullSearch(m,n,3)
    }else {
        a.append("DR")
        for(i in 0 until n/2 -1) a.append("RURD")
        a.append("D")
        for (i in 0 until n-1) a.append("L")
        a.append("D")
        fullSearch(m,n,3)
    }
}

private fun search(m: Int, n: Int) {
    for (i in 0 until m-1) a.append("R")
    a.append("D")
    a.append("D")
    for (i in 0 until n/2) {
        a.append("LULD")
    }
    a.append("D")
    fullSearch(m,n,3)
}

fun fullSearch(m: Int, n: Int,index : Int) {
    var switch = 1
    for (i in index until m) {
        for (j in 0 until n - 1) {
            if (switch == 1) {
                a.append("R")
            } else {
                a.append("L")
            }
        }
        switch *= -1
        if (i != m - 1) a.append("D")
    }
}
