package 백준

private val color = arrayOf("black","brown","red","orange","yellow","green","blue","violet","grey","white")
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val first = br.readLine()
    val second = br.readLine()
    val third = br.readLine()
    val a = (color.indexOf(first) * 10 + color.indexOf(second)).toLong()
    val answer = (a * (Math.pow(10.toDouble(), color.indexOf(third).toDouble()))).toLong()
    println(answer)
    bw.flush()
}