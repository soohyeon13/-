package 카카오인턴대비.level2

class Level2BigAndSmall {
    fun solution(s: String) :String {
        val arr = s.split(" ").map { it.toInt() }
        val answer = arr.sorted()
        return "${answer[0]} ${answer[answer.size-1]}"
    }
}