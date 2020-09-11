package sort

fun main() {
    val testArr = listOf<Int>(2,4,7,3,6,9,1,5,0)
    val testArr2 = listOf<Int>(2,4,7,3,6,9,1,5,0)
    testArr.minus(testArr2)
    val ordered = quicksort(testArr)
    println("ordered ${ordered.toString()}")
}

private fun quicksort(items:List<Int>):List<Int> {
    if (items.count() < 2) {
        return items
    }
    val pivot = items[items.count()/2]

    val equal = items.filter { it == pivot }
    println("equal ${equal.toString()}")

    val less = items.filter{it < pivot}
    println("less ${less.toString()}")

    val greater = items.filter { it>pivot }
    println("greater ${greater.toString()}")

    return quicksort(less) + equal + quicksort(greater)
}