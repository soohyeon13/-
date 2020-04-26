package 카카오인턴대비.level2

import java.rmi.dgc.VMID.isUnique


class Level2CandidateKey {
    private var rowCnt = 0
    private var find = 0
    private lateinit var table : Array<Array<String>>
    private val keyList = ArrayList<Int>()
    fun solution(relation: Array<Array<String>>): Int {
        var columnCnt = relation[0].size
        rowCnt = relation.size
        table = relation.clone()
        var count = 0
        return 0
    }
}
