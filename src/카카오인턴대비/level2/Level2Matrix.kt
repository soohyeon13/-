package 카카오인턴대비.level2

class Level2Matrix {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>) :Array<IntArray> {
        val answer = Array(arr1.size){IntArray(arr2[0].size)}
        for (i in arr1.indices) {
            for (j in arr1[0].indices) {
                for (k in arr2[0].indices) {
                    answer[i][k] += (arr1[i][j] * arr2[j][k])
                }
            }
        }
        return answer
    }
}