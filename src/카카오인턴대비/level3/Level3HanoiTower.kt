package 카카오인턴대비.level3

class Level3HanoiTower {
    fun solution(n:Int) : Array<IntArray> {
        val arr = ArrayList<IntArray>()
        move(1,2,3,n,arr)
        return arr.toTypedArray()
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