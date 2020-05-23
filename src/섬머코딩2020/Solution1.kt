package 섬머코딩2020

class Solution1 {
    fun solution(p: Int): Int {
        var answer = 0
        for (i in p+1 .. 10000) {
            if (check(i)) {
                answer = i
                break
            }
        }
        return answer
    }
    private fun check(p: Int) : Boolean {
        val map = HashMap<Char,Boolean>()
        val arr = p.toString().toCharArray()
        for (i in arr.indices) {
            if (!map.containsKey(arr[i])) map[arr[i]] = true
            else return false
        }
        return true
    }
}