package 카카오인턴대비.level2

class Level2BigNum {
    fun solution(number:String,k:Int) : String {
        val answer = StringBuilder()
        val arr = number.toCharArray().map { it.toString().toInt() }
        var start = 0
        var save = 0
        var end = k
        while (answer.length < number.length-k) {
            var big = 0
            for (i in start .. end) {
                if (big < arr[i]) {
                    big = arr[i]
                    save = i
                }
            }
            start = save+1
            end +=1
            answer.append(big.toString())
        }
        return answer.toString()
    }
}