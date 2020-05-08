package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }
    var left : Long = 1
    var right : Long = 6000000000
    var cnt :Long= 0
    var answer : Long= 0
    while (left <= right) {
        val mid = (left + right) /2
        cnt = 0
        for (i in arr.indices) {
            cnt += mid/arr[i]
            if (cnt > n-m) break
        }
        if (cnt <= n-m) {
            left = mid +1
            answer = mid -1
        }else {
            right = mid -1
        }
    }
    cnt = 0
    for (i in arr.indices) {
        cnt += answer/arr[i]
    }
    val remain = (n-m) - cnt
    var a = 0
    var b = 0
    for (i in arr.indices) {
        if ((answer+1).toInt()%arr[i] == 0) a+=1
        if (a == remain.toInt()) {
            b = i+1
            break
        }
    }
    println(b)
    bw.flush()
}

