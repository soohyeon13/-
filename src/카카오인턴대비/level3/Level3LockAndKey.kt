package 카카오인턴대비.level3

class Level3LockAndKey {
    private lateinit var expandLock: Array<IntArray>
    private var home = 0
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val keySize = key.size - 1
        val expandSize = lock.size + (keySize * 2)
        expandLock = Array(expandSize) { IntArray(expandSize) { -1 } }
        for (i in lock.indices) {
            for (j in lock[i].indices) {
                if (lock[i][j] == 0) home+=1
                expandLock[i + keySize][j + keySize] = lock[i][j]
            }
        }
        for (i in 0 until expandSize-keySize) {
            for (j in 0 until expandSize-keySize) {
                var copyKey = key.clone()
                for (k in 0 until 4) {
                    if (check(expandLock,copyKey,i,j)) return true
                    copyKey = rotation(copyKey)
                }
            }
        }
        return false
    }
    private fun check(expandLock : Array<IntArray>,key:Array<IntArray>,a:Int,b:Int) : Boolean {
        var homeCnt = 0
        for (i in key.indices) {
            for (j in key[i].indices) {
                if (expandLock[a+i][b+j] == 1 && key[i][j] == 1) return false
                else if (expandLock[a+i][b+j] == 0 && key[i][j] == 1) {
                    homeCnt +=1
                }
            }
        }
        return homeCnt == home
    }

    private fun rotation(originKey: Array<IntArray>): Array<IntArray> {
        val rotateKey = Array(originKey.size) { IntArray(originKey.size) }
        val index = originKey.size - 1
        for (i in originKey.indices) {
            for (j in originKey[i].indices) {
                rotateKey[i][j] = originKey[index - j][i]
            }
        }
        return rotateKey
    }
}