package 카카오2020

class LiveEating {
    fun solution(food_times:IntArray,k:Long) :Int {
        val arr = ArrayList<Food>()
        for (i in food_times.indices) {
            arr.add(Food(food_times[i],i+1))
        }
        arr.sortBy { it.time }
        var size = food_times.size
        var remain : Long = k
        var time1  = 0
        var time2 : Int
        for (i in arr.indices) {
            time2 = arr[i].time
            val use =(time2.toLong() - time1.toLong()) * size.toLong()
            if (use > remain) {
                return arr.drop(food_times.size - size)
                        .sortedBy { it.index }[(remain%size).toInt()].index
            }
            remain -= use
            time1 = time2
            size -=1
        }
        return -1
    }
}
data class Food(
        var time :Int,
        var index : Int
)