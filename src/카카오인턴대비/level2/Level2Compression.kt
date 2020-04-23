package 카카오인턴대비.level2

class Level2Compression {
    fun solution(s: String): Int {
        val halfLen = s.length / 2
        var answer = s.length
        for (i in 1..halfLen) {
            val arr = s.chunked(i)
            val word = StringBuilder()
            var cnt = 1
            for (j in 0..arr.size - 2) {
                if (arr[j] == arr[j + 1]) {
                    cnt++
                } else {
                    if (cnt != 1) {
                        word.append("${cnt}${arr[j]}")
                    } else if (cnt == 1) {
                        word.append(arr[j])
                    }
                    cnt = 1
                }
                if (j == arr.size - 2) {
                    if (cnt != 1) {
                        word.append("${cnt}${arr[j+1]}")
                    } else if (cnt == 1) {
                        word.append(arr[j+1])
                    }
                }
            }
            if (answer > word.length) answer = word.length
        }
        return answer
    }
}