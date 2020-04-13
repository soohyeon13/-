package 카카오2020

class Convert {
    fun solution(p:String):String {
        return balance(p)
    }
    private fun balance(w : String) : String {
        if(w.isEmpty()) return ""
        var cnt = division(w)
        var u = w.substring(0,cnt)
        var v = w.substring(cnt,w.length)
        if (isCorrect(u)) {
            return  u + balance(v)
        }else {
            val temp = '(' + balance(v) + ')'
            u = u.substring(1,u.length-1)
            u = reverse(u)
            return temp + u
        }
    }
    private fun reverse(w: String) : String {
        val ret = StringBuilder()
        val arr = w.toCharArray()
        for (i in arr.indices) {
            if (arr[i] == ')') ret.append('(')
            else ret.append(')')
        }
        return ret.toString()
    }

    private fun isCorrect(u: String): Boolean {
        var count = 0
        val arr = u.toCharArray()
        for (i in arr.indices) {
            if (arr[i] == '(') count +=1
            else count -=1
            if (count < 0) return false
        }
        return count == 0
    }

    private fun division(w: String): Int {
        var close = 0
        var open = 0
        val arr = w.toCharArray()
        var cnt = 0
        for (i in arr.indices) {
            if(arr[i] == '(') open += 1
            else close +=1
            if (open == close) {
                cnt = i+1
                break
            }
        }
        return cnt
    }
}