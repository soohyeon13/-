package 카카오인턴대비.level2

class Level2Target {
    fun solution(numbers: IntArray, target: Int): Int {
        return dfs(numbers, target, 0, 0)
    }

    private fun dfs(numbers: IntArray, target: Int, index: Int, num: Int): Int {
        return if (index == numbers.size) {
            if (target == num) 1 else 0
        } else {
            dfs(numbers, target, index + 1, num + numbers[index])
            +dfs(numbers, target, index + 1, num - numbers[index])
        }
    }
}