package 카카오인턴대비.level3

class Level3BridgeConn {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        val arr = costs.sortedBy { it[2] }
        val set = Array(n) { i -> i }
        var sum = 0
        arr.forEach { println(it.contentToString()) }
        for (i in arr.indices) {
            println("a : ${arr[i][0]} b: ${arr[i][1]}")
            if (!find(set, arr[i][0], arr[i][1])) {
                sum += arr[i][2]
                println("set: ${set.contentToString()}")
                unionParent(set,arr[i][0],arr[i][1])
            }
        }
        return sum
    }
    private fun unionParent(set: Array<Int>, a: Int, b: Int) {
        val x = getParent(set,a)
        val y = getParent(set,b)
        println("union x:$x y:$y a:$a b:$b")
        set[Math.max(x,y)] = Math.min(x,y)
    }

    private fun find(set: Array<Int>, a: Int, b: Int): Boolean {
        val x = getParent(set, a)
        val y = getParent(set, b)
        println("find x:$x y:$y a:$a b:$b")
        return x == y
    }

    private fun getParent(set: Array<Int>, a: Int): Int {
        println("getParent set: ${set[a]} a : $a")
        if (set[a] == a) return a
        return getParent(set, set[a])
    }
}