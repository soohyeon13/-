package 카카오인턴대비.level3

import java.util.*

class Level3BuildStructure {
    private val arr = LinkedList<IntArray>()
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        for (i in build_frame.indices) {
            if (build_frame[i][3] == 1) {
                buildStructure(build_frame[i][0],build_frame[i][1],build_frame[i][1])
            }
        }
        arr.forEach{
            println(it.contentToString())
        }
        val answer = arrayOf(intArrayOf(1))
        return answer
    }

    private fun buildStructure(x: Int, y: Int, structure: Int) {
        if (structure == 0 && checkPillar(x, y)) {
            arr.add(intArrayOf(x,y,0))
        } else if (structure == 1 && checkFloor(x,y)) {
            arr.add(intArrayOf(x,y,1))
        }
    }

    private fun checkPillar(x: Int, y: Int): Boolean {
        if (x == 0 || arr.contains(intArrayOf(x - 1, y, 1)) || arr.contains(intArrayOf(x, y + 1, 0))) {
            return true
        }
        return false
    }

    private fun checkFloor(x: Int, y: Int): Boolean {
        if (arr.contains(intArrayOf(x,y-1,0)) || arr.contains(intArrayOf(x+1,y-1,0))) {
            return true
        }else if (arr.contains(intArrayOf(x-1,y,1)) && arr.contains(intArrayOf(x+1,y,1))) {
            return true
        }
        return false
    }

    private fun removeStructure(x:Int,y:Int,structure:Int) {
        if (structure == 0) {
            checkFloor(x-1,y+1)
            checkFloor(x,y+1)
            checkFloor(x+1,y+1)
        }else if (structure ==1) {
            checkFloor(x-1,y)
            checkPillar(x,y)
            checkFloor(x+1,y)
        }
    }
}