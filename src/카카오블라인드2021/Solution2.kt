package 카카오블라인드2021

class Solution2 {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val map = HashMap<String,ArrayList<Int>>()
        for (i in orders.indices) {
            val row = orders[i].toCharArray()
            for (j in row.indices) {
                if (map.containsKey(row[j].toString())) {
                    map[row[j].toString()]?.add(i+1)
                }else {
                    val arr = ArrayList<Int>()
                    arr.add(i+1)
                    map[row[j].toString()] = arr
                }
            }
        }
        val a =map.toList().sortedByDescending { it.second.size }
        println(a.toString())
        println(map.toString())
        return answer
    }
}