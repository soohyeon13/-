package 카카오2020

import java.util.*

class 외벽점검 {
    var minCnt = Integer.MAX_VALUE
    fun solution(n:Int,weak:IntArray,dist:IntArray) : Int {
        dist.sortDescending()
        if (weak.size ==1) return 1
        purmutation(n,weak,dist,0)
        if (minCnt == Integer.MAX_VALUE) return -1
        return minCnt
    }

    private fun purmutation(n: Int, weak: IntArray, dist: IntArray, cnt: Int) {
        if (cnt >= dist.size) {
            var curCnt = checkLine(n,weak,dist)
            if (minCnt > curCnt) {
                minCnt = curCnt
            }
            return
        }
        for (i in cnt until dist.size) {
            swap(dist,i,cnt)
            purmutation(n,weak,dist,cnt+1)
            swap(dist,i,cnt)
        }
    }

    private fun swap(dist: IntArray, i: Int, cnt: Int) {
        val temp = dist[i]
        dist[i] = dist[cnt]
        dist[cnt] = temp
    }

    private fun checkLine(n: Int, weak: IntArray, dist: IntArray): Int {
        root@ for (cnt in 0 until weak.size) { //시작점을 다르게하여 모든 case 체크
            var index = 0
            var prev = weak[cnt]
            var runner = dist[index]
            root2@ for (i in 1 until weak.size) {
                if (index >= minCnt) {
                    break@root2
                }
                var next = weak[(i + cnt) % weak.size]
                var distance =
                        if (prev > next) {    // 끝 지점 통과
                            next + n - prev
                        } else {
                            next - prev
                        }
                prev = next
                if (runner >= distance) {
                    runner -= distance
                } else {
                    if (index >= dist.size - 1) {
                        continue@root
                    }
                    runner = dist[++index]
                    if(i >= weak.size - 1 ) {
                        break@root2
                    }
                }
            }
            if (minCnt > index + 1) {
                minCnt = index + 1
            }
        }

        return minCnt
    }
}