package 백준


private var l = 0
private var r = 0
private var x = 0
private var answer = 0
fun main() {
    val input = System.`in`.bufferedReader()
    val (N, L, R, X) = input.readLine().split(" ").map { it.toInt() }
    l = L
    r = R
    x = X
    val problems = input.readLine().split(" ").map { it.toInt() }.toIntArray()
    for (i in 2..N) {
        val visited = BooleanArray(N)
        combination(problems, visited, 0, N, i)
    }
    println(answer)
}

private fun combination(arr: IntArray, visited: BooleanArray, start: Int, n: Int, r: Int) {
    if (r == 0) {
        val p = ArrayList<Int>()
        for (i in visited.indices) {
            if (visited[i]) p.add(arr[i])
        }
        isCheckProblem(p.toIntArray())
        return
    }
    for (i in start until n) {
        visited[i] = true
        combination(arr, visited, i + 1, n, r - 1)
        visited[i] = false
    }
}

private fun isCheckProblem(problem: IntArray) {
    val problemSum = problem.sum()
    val minProblem = problem.min()
    val maxProblem = problem.max()
    if (problemSum in l..r && (maxProblem!! - minProblem!!) >= x) {
        answer++
        return
    }
}