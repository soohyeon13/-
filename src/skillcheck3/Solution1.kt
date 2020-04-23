package skillcheck3

// [[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]

class Solution1 {
    private lateinit var visite : Array<Boolean>
    private var answer = 0
    fun solution(N:Int,road:Array<IntArray>,k:Int): Int {
        visite = Array(N+1){false}
        visite[1]= true
        for (i in road.indices) {
            if (road[i][0] == 1) {
                val to = road[i][1]
                val time = k - road[i][2]
                println("1 :$to")
                dfs(to,time,road)
            }
        }
        return answer
    }
    private fun dfs(to: Int, time: Int, road: Array<IntArray>) {
        if (!visite[to]) {
            for (i in road.indices) {
                val nxFrom = road[i][0]
                val nxTo = road[i][1]
                val nxTime = time - road[i][2]
                if (nxTime >= 0 && !visite[nxTo] && nxFrom == to) {
                    answer++
                    visite[to] = true
                    println("$nxFrom -> $nxTo")
                    dfs(nxTo,time,road)
                }else if (nxTime>=0 && !visite[nxFrom] && nxTo == to) {
                    answer++
                    visite[to] = true
                    println("nxFrom:$nxFrom - nxTo:$nxTo")
                    dfs(nxFrom,nxTime,road)
                }
            }
        }
    }
}