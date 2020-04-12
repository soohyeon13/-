package 스택큐

class FuncDevelop {
    fun solution(progresses: IntArray,speeds : IntArray):IntArray {
        var cnt = 1
        val answer = mutableListOf<Int>()
        var remainDay = 0
        var saveDay =0
        var index = 0
        saveDay = (100-progresses[index])/speeds[index]
        if ((100-progresses[index])%speeds[index] > 0) saveDay +=1
        while (index < progresses.size-1) {
            index +=1
            remainDay = (100-progresses[index])/speeds[index]
            if ((100-progresses[index])%speeds[index] > 0) remainDay +=1
            if (saveDay >= remainDay) {
                cnt +=1
            }else {
                answer.add(cnt)
                saveDay = remainDay
                cnt =1
            }
        }
        answer.add(cnt)
        return answer.toIntArray()
    }
}