package skillcheck4

private var answer = 0
class Solution2 {
    fun solution(n: Int): Int {
        dfs(1,0,1,n)
        return answer
    }
    private fun dfs(left: Int, right: Int, cnt : Int,n: Int) {
        if (left< right || left > n || right> n) {
            return
        }
        if (cnt == n *2) {
            answer +=1
            return
        }
        dfs(left+1,right,cnt+1,n)
        dfs(left,right+1,cnt+1,n)
    }
}