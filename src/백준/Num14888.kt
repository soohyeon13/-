package 백준

private var resultMax = Int.MIN_VALUE
private var resultMin = Int.MAX_VALUE
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    val operatorArr = br.readLine().split(" ").map { it.toInt() }
    dfs(arr,1,arr[0],operatorArr[0],operatorArr[1],operatorArr[2],operatorArr[3])
    println(resultMax)
    println(resultMin)
    bw.flush()
}
private fun dfs(arr: List<Int>, depth: Int, result: Int, add: Int, sub: Int, mul: Int, div: Int) {
    if (depth == arr.size) {
        resultMax = Math.max(resultMax,result)
        resultMin = Math.min(resultMin,result)
    }else {
        if (add != 0) {
            dfs(arr,depth+1,result+arr[depth],add-1,sub, mul, div)
        }
        if (sub != 0) {
            dfs(arr,depth+1,result-arr[depth],add,sub-1, mul, div)
        }
        if (mul != 0) {
            dfs(arr,depth+1,result*arr[depth],add,sub, mul-1, div)
        }
        if (div != 0) {
            dfs(arr,depth+1, division(result,arr[depth]),add,sub, mul, div-1)
        }
    }
}
private fun division(result : Int, num : Int) : Int {
    if(result < 0) {
        val a= Math.abs(result)
        return (a/num) * -1
    }else {
        return result/num
    }
}