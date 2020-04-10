package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw =  System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    val coinArray = ArrayList<Int>()
    for (i in 0 until cnt[0].toInt()) {
        coinArray.add(br.readLine().toInt())
    }
    coinArray.sortDescending()
    var coinCnt = 0
    var money = cnt[1].toInt()
    for (i in coinArray.indices) {
        if (money % coinArray[i] != 0) {
            coinCnt += money/coinArray[i]
            money %= coinArray[i]
        }else {
            coinCnt += money/coinArray[i]
            break
        }
    }
    println(coinCnt)
    bw.flush()
}