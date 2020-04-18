package 백준

private lateinit var a: Array<BooleanArray>
private var n = 0
private var m = 0
private var h = 0
private var ans = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().split(" ")
    m = cnt[0].toInt()
    h = cnt[1].toInt()
    n = cnt[2].toInt()
    a = Array(n + 2) { BooleanArray(m + 2) }
    for (i in 0 until h) {
        val xy = br.readLine().split(" ")
        val x = xy[0].toInt()
        val y = xy[1].toInt()
        a[x][y] = true
    }
    solve(1, 1, 0, a)
    if(ans >=4) {
        println(-1)
    }else println(ans)
    bw.flush()
}

fun solve(x: Int, y: Int, cnt: Int, a: Array<BooleanArray>) {
    var xx = x
    var yy = y
    if (yy == m+1) {
        ++xx
        yy =1
    }
    if (cnt ==3 || (xx == n && yy ==m )) {
        if (check(a)) {
            ans = Math.min(ans,cnt)
        }
        return
    }
    solve(xx,yy+1,cnt,a)
    if (yy == m || a[xx][yy] || (yy != 1 && a[xx][yy-1] || a[xx][yy+1])) return
    a[xx][yy] = true
    solve(xx,yy+1,cnt+1,a)
    a[xx][yy] = false
}
private fun check(a : Array<BooleanArray>) : Boolean {
    for (i in 1 .. m) {
        var start = i
        var end = i
        for (j in 1 .. n) {
            if (a[j][end]) {
                ++end
                continue
            }
            if (end == 1) continue
            if (!a[j][end]) {
                if (a[j][end-1]) --end
            }
        }
        if (start != end) return false
    }
    return true
}