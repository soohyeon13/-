package 카카오인턴대비.level2

class Level2Tower {
    fun solution(heights : IntArray) :IntArray {
        val arr = Array(heights.size) {0}
        for(i in heights.size-1 downTo 1) {
            val tower = heights[i]
            for (j in i -1 downTo 0) {
                if (tower < heights[j]) {
                    arr[i] = i+1
                    break
                }
            }
        }
        println(arr.contentToString())
        return arr.toIntArray()
    }
}