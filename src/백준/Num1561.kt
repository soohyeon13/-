package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val arr = br.readLine().split(" ").toList()
    val time = checkTime(cnt,arr) -1
    var remain = cnt[1].toLong()
    for (i in 0 until cnt[1].toInt()) {
        remain += time/arr[i].toLong()
    }
    val remainChild = cnt[0].toInt() - remain.toInt()
    var count = 0
    var index = 0
    while (true) {
        if (((time+1)/arr[index].toLong()) != (time/arr[index].toLong())) {
            count +=1
        }
        index +=1
        if (count == remainChild) break
    }
    println(index)
    bw.flush()
}

fun checkTime(cnt: List<String>, arr: List<String>): Long {
    var left : Long= 0
    var right : Long = 2000000000L * 30L
    var answer : Long= -1
    var mid : Long= 0
    while (left <= right) {
        mid = (left+right)/2
        var child = cnt[1].toLong()
        for (i in 0 until  cnt[1].toInt()) {
            child += mid/arr[i].toInt()
        }
        if (child>=cnt[0].toLong()) {
            answer = mid
            right = mid-1
        }else left = mid +1
    }
    return answer
}

