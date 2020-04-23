package 카카오인턴대비.level2

class Level2Decimal {
    private val set = HashSet<Int>()
    fun solution(numbers:String) :Int {
        val arr = numbers.toCharArray()
        var answer = 0
        for (i in 1 .. numbers.length) {
            permutation(arr,0,i)
        }
        println(set.toString())
        loop@for (element in set) {
            if (element <2) continue@loop
            for (j in 2 until  element) {
                if (element % j == 0) continue@loop
            }
            answer +=1
        }
        return answer
    }

    private fun permutation(arr:CharArray, depth: Int, r: Int) {
        if (depth == r) {
            val word = StringBuilder()
            for (i in 0 until r) {
                word.append(arr[i])
            }
            set.add(word.toString().toInt())
            return
        }
        for (i in depth until arr.size) {
            swap(arr,depth,i)
            permutation(arr,depth+1,r)
            swap(arr,depth,i)
        }
    }

    private fun swap(arr:CharArray,i:Int,j:Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}