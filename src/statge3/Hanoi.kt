package statge3

class Hanoi {
    fun solution(n:Int) : Array<IntArray> {
        val arr = ArrayList<IntArray>()
        move(1,2,3,n,arr)
        val answer = Array(arr.size){IntArray(2)}
        var index = 0
        arr.forEach { answer[index++] = it }
        return answer
    }
    private fun move(start: Int,mid: Int ,end:Int,n:Int,route:ArrayList<IntArray>)  {
        println("start : $start mid : $mid end : $end")
        if(n == 1) route.add(intArrayOf(start,end))
        else {
            move(start,end,mid,n-1,route)
            route.add(intArrayOf(start,end))
            move(mid,start,end,n-1,route)
        }
    }
}