package 백준

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val word = br.readLine()
    val words = word.toCharArray()
    val C = 10
    val D = 26
    var save = ' '
    var totalCnt = 1
    for (i in words.indices) {
        when(words[i]) {
            'd' -> {
                if(save != 'd') totalCnt *= C
                else totalCnt *=(C-1)
            }
            'c' -> {
                if (save != 'c') totalCnt *= D
                else totalCnt *= (D-1)
            }
        }
        save = word[i]
    }
    println(totalCnt)
}