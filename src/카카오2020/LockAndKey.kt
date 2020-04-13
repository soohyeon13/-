package 카카오2020

class LockAndKey {
    var totalCnt = 0
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val expandSize = lock.size + (key.size - 1) * 2
        val expandLock = Array(expandSize) { IntArray(expandSize) { -1 } }
        for (i in lock.indices) {
            for (j in lock[i].indices) {
                if (lock[i][j] == 0) totalCnt += 1
                expandLock[i + (lock.size - 1)][j + (lock.size - 1)] = lock[i][j]
            }
        }
        for (i in 0..expandSize - key.size) {
            for (j in 0..expandSize - key.size) {
                if (correctKey(expandLock, key, i, j)){
                    return true
                }
            }
        }
        return false
    }

    private fun correctKey(expandLock: Array<IntArray>, key: Array<IntArray>, a: Int, b: Int): Boolean {
        var rotatekey = key.clone()
        for (k in 0 until 4) {
            var count = 0
            rotatekey = rotate(rotatekey)
            loop@ for (i in key.indices) {
                for (j in key[i].indices) {
                    if (expandLock[i + a][j + b] == 1 && rotatekey[i][j] == 1) {
                        break@loop
                    }
                    if (expandLock[i + a][j + b] == 0 && rotatekey[i][j] == 1) count += 1
                }
                if (i == key.size-1) {
                    if (totalCnt == count) return true
                }
            }
        }
        return false
    }

    private fun rotate(rotateKey: Array<IntArray>): Array<IntArray> {
        val key = Array(rotateKey.size) { IntArray(rotateKey.size) }
        val index = rotateKey.size -1
        for (i in key.indices) {
            for (j in key[i].indices) {
                key[i][j] = rotateKey[index-j][i]
            }
        }
        return key
    }
}