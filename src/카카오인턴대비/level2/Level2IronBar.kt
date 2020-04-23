package 카카오인턴대비.level2

class Level2IronBar {
    fun solution(arrangement: String): Int {
        var num = 0
        var answer = 0
        val arr = ArrayList<Char>()
        var check = false
        for (i in 0 until arrangement.length - 1) {
            if (check) {
                check = false
                continue
            }
            if (arrangement[i] == '(' && arrangement[i + 1] == ')') {
                arr.add('L')
                check = true
            } else arr.add(arrangement[i])
        }
        if (!check) arr.add(')')
        for (i in arr.indices) {
            if (arr[i] == 'L') {
                answer += num
                continue
            }
            if (arr[i] == '(') {
                num += 1
            } else if (arr[i] == ')') {
                num -= 1
                answer += 1
            }
        }
        return answer
    }
}