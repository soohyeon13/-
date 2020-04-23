package 카카오인턴대비.level2

class Level2OpenChat {
    private val map = HashMap<String,String>()
    private val arr = ArrayList<String>()
    fun solution(record:Array<String>):Array<String> {
        for (i in record.indices) {
            val list = record[i].split(" ")
            when(list[0]) {
                "Enter"-> {
                    map[list[1]] = list[2]
                    arr.add("${list[1]} 들어왔습니다.")
                }
                "Leave" -> {
                    arr.add("${list[1]} 나갔습니다.")
                }
                "Change"-> {
                    map[list[1]] = list[2]
                }
            }
        }
        val answer = Array(arr.size){" "}
        for (i in arr.indices) {
            val log = StringBuilder()
            val list = arr[i].split(" ")
            log.append("${map[list[0]]}님이 ${list[1]}")
            answer[i] = log.toString()
        }
        return answer
    }
}