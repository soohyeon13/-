package 카카오인턴대비.level3

class Level3NQueen {
    private var N = 0
    private lateinit var cols : IntArray
    private var answer = 0
    fun solution(n: Int): Int {
        N = n
        cols = IntArray(n)
        check(0)
        return answer
    }
    private fun check(a:Int) {
        if (a == N) {
            answer++
        }else {
            for (i in 0 until N) {
                cols[a] = i
                if (isCheck(a)) {
                    check(a+1)
                }
            }
        }
    }
    private fun isCheck(a: Int) : Boolean {
        for (i in 0 until a) {
            if (cols[i] - cols[a] == 0 || (Math.abs(cols[i] - cols[a]) - Math.abs(i-a)) == 0) {
                return false
            }
        }
        return true
    }
}