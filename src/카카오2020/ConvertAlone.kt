package 카카오2020

class ConvertAlone {
    fun solution(p: String): String {
        return balence(p)
    }

    private fun balence(w: String): String {
        if (w.isEmpty()) return ""
        val check = checkPoint(w)
        var u = w.substring(0,check)
        var v = w.substring(check,w.length)
        if (isCorrect(u)) {
            return u + balence(v)
        }else {
            val emptyWrod = "(" + balence(v) + ")"
            val a = u.substring(1,u.length-1)
            val b = reversWord(a)
            return emptyWrod + b
        }
    }

    private fun reversWord(w: String): String {
        val revers = StringBuilder()
        val arr = w.toCharArray()
        for (i in arr.indices) {
            if (arr[i] == '(') revers.append(')')
            else revers.append('(')
        }
        return revers.toString()
    }

    private fun isCorrect(u: String): Boolean {
        var count = 0
        val arr = u.toCharArray()
        for (i in arr.indices) {
            if (arr[i] == '(') count +=1
            else count -=1
            if (count <0) return false
        }
        return count ==0
    }

    private fun checkPoint(w: String): Int {
        var count = 0
        val arr = w.toCharArray()
        for (i in arr.indices) {
            if (arr[i] == '(') count += 1
            else count -= 1
            if (count == 0) {
                count = i + 1
                break
            }
        }
        return count
    }
}