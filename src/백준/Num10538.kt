package 백준

private lateinit var picture : Array<CharArray>
private lateinit var bigPicture : Array<CharArray>
private var answer = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (hp,wp,hm,wm) = br.readLine().split(" ").map { it.toInt() }
    picture = Array(hp){CharArray(wp)}
    bigPicture = Array(hm){CharArray(wm)}
    for (i in 0 until hp) {
        val row = br.readLine().toCharArray()
        for (j in row.indices) {
            picture[i][j] = row[j]
        }
    }
    for (i in 0 until hm) {
        val row = br.readLine().toCharArray()
        for (j in row.indices) {
            bigPicture[i][j] = row[j]
        }
    }
    for (i in 0 ..hm-hp) {
        for (j in 0 .. wm-wp) {
            if (bigPicture[i][j] == picture[0][0]) {
                if (checkPicture(i,j)) answer++
            }
        }
    }
    println(answer)
    bw.flush()
}

private fun checkPicture(x :Int , y : Int) : Boolean{
    for (i in picture.indices) {
        for (j in picture[i].indices) {
            if (picture[i][j] != bigPicture[x+i][y+j]) return false
        }
    }
    return true
}