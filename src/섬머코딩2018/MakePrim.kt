package 섬머코딩2018

class MakePrim {
    private val prim = Array(3000){true}
    private var answer = 0
    fun solution(nums: IntArray): Int {
        val visited = Array(nums.size){false}
        findPrim()
        comb(nums,visited,0,nums.size,3)
        return answer
    }
    private fun findPrim() {
        for (i in 2 until 3000) {
            for (j in i+i until 3000 step i) {
                prim[j] = false
            }
        }
    }
    private fun comb(nums: IntArray, visited: Array<Boolean>, start: Int, size: Int, r: Int) {
        if (r==0) {
            var sum = 0
            for (i in visited.indices) {
                if (visited[i]) {
                    sum += nums[i]
                }
            }
            if (prim[sum]) answer +=1
            return
        }
        for (i in start until size) {
            visited[i] = true
            comb(nums,visited,i+1,size,r-1)
            visited[i]= false
        }
    }
}