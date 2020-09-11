package 월간코테.첫번째

class Solution3 {
    fun solution(a: IntArray): Int {
        var answer = 2
        for (i in 1 until a.size - 1) {
            val arr = ArrayList<Int>()
            val l = checkLeft(a, i)
            val r = checkRight(a, i)
            arr.add(l)
            arr.add(r)
            arr.add(a[i])
            arr.sort()
            if (arr[0] == a[i] || arr[1] == a[i]) answer++
        }
        return answer
    }

    private fun checkRight(a: IntArray, index: Int): Int {
        return a.drop(index + 1).min()!!
    }

    private fun checkLeft(a: IntArray, index: Int): Int {
        return a.dropLast(a.size - index).min()!!
    }
}
