package 카카오인턴대비.level2

class Level2Carpet {
    fun solution(brown: Int, red: Int): IntArray {
        return (1..red)
                .filter {
                    println("filter $it")
                    red % it == 0
                }
                .first {
                    println("first $it")
                    brown == (red / it * 2) + (it * 2) + 4 }
                .let {
                    println("let $it")
                    intArrayOf(red / it + 2, it + 2) }
    }
}
fun main() {
    val sol = Level2Carpet()
    println(sol.solution(24,24))
}