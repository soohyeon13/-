package 백준
private var saveCnt = 0
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val cnt = br.readLine().toInt()
    val list = Array(cnt) { Array<String>(cnt, { "" }) }
    for (i in 0 until cnt) {
        for (j in 0 until cnt-1) {
            var temp = list[i][j]
            list[i][j] = list[i][j+1]
            list[i][j+1] = temp
            check(cnt,list)
            temp = list[i][j+1]
            list[i][j+1] = list[i][j]
            list[i][j] = temp

            temp = list[j][i]
            list[j][i] = list[j+1][i]
            list[j+1][i] = temp
            check(cnt,list)
            temp = list[j+1][i]
            list[j+1][i] = list[j][i]
            list[j][i] = temp
        }
    }
    println(saveCnt)
}
private fun check(n : Int,array : Array<Array<String>>) {
    for (i in 0 until n) {
        var cnt = 1
        for (j in 1 until n) {
            if (array[i][j] == array[i][j-1]) {
                cnt += 1
            }else {
                saveCnt = Math.max(saveCnt,cnt)
                cnt =1
            }
        }
        saveCnt = Math.max(saveCnt,cnt)
    }
    for (i in 0 until n) {
        var cnt = 1
        for (j in 1 until n) {
            if (array[j][i] == array[j-1][i]) {
                cnt+=1
            }else {
                saveCnt = Math.max(saveCnt,cnt)
                cnt =1
            }
        }
        saveCnt = Math.max(saveCnt,cnt)
    }
}

//fun main() {
//    val br = System.`in`.bufferedReader()
//    val bw = System.out.bufferedWriter()
//    val cnt = br.readLine().toInt()
//    val list = Array(cnt) { Array<String>(cnt, { "" }) }
//    for (i in 0 until cnt) {
//        val word = br.readLine().toCharArray()
//        for (j in word.indices) {
//            list[i][j] = word[j].toString()
//        }
//    }
//    for (i in list.indices) {
//        for (j in 0 until list[i].size - 1) {
//            if (list[i][j] != list[i][j + 1]) {
//                horizontalSwap(i, j, list)
//                horizontalCheck(i, j, list)
//                horizontalSwap(i, j, list)
//            }
//        }
//    }
//    for (i in 0 until list.size -1) {
//        for (j in list[i].indices) {
//            if(list[i][j] != list[i+1][j]) {
//                verticalSwap(i,j,list)
//                verticalCheck(i,j,list)
//                verticalSwap(i,j,list)
//            }
//        }
//    }
//    println(saveCnt)
//}
//
//private fun verticalCheck(a: Int, b: Int, arrays: Array<Array<String>>) {
//    val map = HashMap<String, Int>()
//    for (i in arrays[a].indices) {
//        if (!map.containsKey(arrays[a][i])) map[arrays[a][i]] = 1
//        else map[arrays[a][i]] = map[arrays[a][i]]!! + 1
//    }
//    val cnts = map
//            .toList()
//            .sortedByDescending { (_, value) -> value }
//    val cnt = cnts[0].second
//    if (saveCnt < cnt) saveCnt = cnt
//}
//
//private fun horizontalCheck(a: Int, b: Int, arrays: Array<Array<String>>) {
//    val map = HashMap<String, Int>()
//    for (i in arrays[a].indices) {
//        if (!map.containsKey(arrays[a][i])) map[arrays[a][i]] = 1
//        else map[arrays[a][i]] = map[arrays[a][i]]!! + 1
//    }
//    val cnts = map
//            .toList()
//            .sortedByDescending { (_, value) -> value }
//    val cnt = cnts[0].second
//    if (saveCnt < cnt) saveCnt = cnt
//}
//
//private fun verticalSwap(a: Int, b: Int, arrays: Array<Array<String>>) {
//    val temp = arrays[a][b]
//    val c = arrays[a + 1][b]
//    arrays[a][b] = c
//    arrays[a + 1][b] = temp
//}
//
//private fun horizontalSwap(a: Int, b: Int, arrays: Array<Array<String>>) {
//    val temp = arrays[a][b]
//    val c = arrays[a][b + 1]
//    arrays[a][b] = c
//    arrays[a][b + 1] = temp
//}