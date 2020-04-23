package 카카오인턴대비.level2

import kotlin.time.measureTime

class Level2Tuple {
    fun solution(s: String): IntArray = arrayListOf<Int>().apply {
        s.split("{", "}", ",")
                .groupBy { it }
                .toList()
                .sortedByDescending { it.second.count() }
                .also {
                    it.takeLast(it.size - 1)
                            .forEach { add(it.first.toInt()) }
                }
    }.toIntArray()

//        val arr = s.substring(2,s.length-2)
//                .split("},{")
//                .sortedBy { it.length }
//        val arr2 = ArrayList<Array<String>>()
//        for (i in arr.indices) {
//            arr2.add(arr[i].split(",").toTypedArray())
//        }
//        var a = arr2[0]
//        val arr3 = ArrayList<Int>()
//        arr3.add(a[0].toInt())
//        for (i in 1 until arr2.size) {
//            for (j in arr2[i].indices) {
//                if (!a.contains(arr2[i][j])) {
//                    arr3.add(arr2[i][j].toInt())
//                    break
//                }
//            }
//            a = arr2[i]
//        }
//        return arr3.toIntArray()
}