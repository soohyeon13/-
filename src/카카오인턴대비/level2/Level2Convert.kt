package 카카오인턴대비.level2

class Level2Convert {
    fun solution(p: String): String {
        return balance(p)
    }

    private fun balance(w: String): String {
        if (w.isBlank()) return ""
        else {
            val twoCondition = wordSplit(w)
            if (wordRight(twoCondition[0])) {
                val v = balance(twoCondition[1])
                return twoCondition[0] + v
            } else {
                var empty = "("
                empty += balance(twoCondition[1]) + ")"
                val remove = twoCondition[0].substring(1, twoCondition[0].length - 1)
                return empty + reverse(remove)
            }
        }
    }

    private fun reverse(w: String): String {
        val word = StringBuilder()
        for (i in 0 until w.length) {
            if (w[i] == '(') word.append(')')
            else if (w[i] == ')') word.append('(')
        }
        return word.toString()
    }

    private fun wordRight(u: String): Boolean {
        var count = 0
        for (i in 0 until u.length) {
            if (u[i] == '(') count += 1
            else if (u[i] == ')') count -= 1
            if (count < 0) return false
        }
        return true
    }

    private fun wordSplit(w: String): Array<String> {
        var count = 0
        var index = 0
        for (i in 0 until w.length) {
            if (w[i] == '(') count++
            else if (w[i] == ')') count--
            if (count == 0) {
                index = i
                break
            }
        }
        val u = w.substring(0, index + 1)
        val v = w.substring(index + 1, w.length)
        return arrayOf(u, v)
    }
}