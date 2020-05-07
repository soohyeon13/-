package 백준

private var cnt = 0
private val sb = StringBuilder()
private val list = ArrayList<Array<String>>()
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = Array(n){i -> (i+1).toString()}
    perm(arr,0,n)
    for (element in list) {
        println(element.contentDeepToString())
    }
    bw.flush()
}

private fun perm(arr: Array<String>,depth: Int , n : Int) {
    if (depth == n) {
        println("aa :${arr.contentDeepToString()}")
        list.add(arr)
    }
    for (i in depth until n) {
        swap(arr,i,depth)
        perm(arr,depth +1 , n)
        swap(arr,i,depth)
    }
}

private fun swap(arr :Array<String> , i : Int, j : Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}