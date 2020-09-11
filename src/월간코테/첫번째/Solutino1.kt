package 월간코테.첫번째

class Solutino1 {
    private val answer = HashSet<Int>()
    fun solution(numbers: IntArray): IntArray {
        val visite = BooleanArray(numbers.size){false}
        combination(numbers,visite,0,numbers.size,2)
        return answer.sorted().toIntArray()
    }

    private fun combination(arr: IntArray,visited : BooleanArray,start:Int,n:Int,r:Int) {
        if (r == 0) {
            var sum = 0
            for (i in visited.indices) {
                if (visited[i]) {
                    sum += arr[i]
                }
            }
            answer.add(sum)
            return
        }
        for (i in start until n) {
            visited[i] = true
            combination(arr,visited,i+1,n,r-1)
            visited[i] = false
        }
    }
}