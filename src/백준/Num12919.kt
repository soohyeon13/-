package 백준
private var sSize =0
private var tSize = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val s = br.readLine()
    var t = br.readLine()
    sSize = s.length
    tSize = t.length
    var answer = 0
    while (sSize <= tSize) {
        if (t.first() == 'A' && t.last() == 'B') break

        if (t.first() == 'B') {
            t = condition1(t)
            println(t)
        }
        if (t.last() == 'A') {
            t = condition2(t)
            println(t)
        }
        println("s : $s t : $t")
        if (s == t)  {
            println("같음")
            answer = 1
            break
        }
    }
    println(answer)
    bw.flush()
}
private fun condition1(t : String) : String {
    var word = t.substring(1,t.length)
    tSize -= 1
    return word.reversed()
}
private fun condition2(t:String): String{
    val word = t.substring(0,t.length-1)
    tSize -=1
    return word
}