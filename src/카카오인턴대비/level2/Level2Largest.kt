package 카카오인턴대비.level2

class Level2Largest {
    fun solution(numbers: IntArray): String {
        val answer = StringBuilder()
        numbers.sortedByDescending {
                    it.toString()
                            .padEnd(4, '%')
                            .replace("%", it.toString())
                }
                .forEach { answer.append(it) }
        val pattern = "[1-9]".toRegex()
        if (pattern.containsMatchIn(answer) == false) {
            return "0"
        }
        return answer.toString()
    }
}