package 카카오인턴대비.level2

class Level2Joystick {
    fun solution(name:String):Int {
        val arr = name.toCharArray()
        var answer =0
        for (i in arr.indices) {
            val ascii =arr[i].toInt()
            if (ascii == 65) {
                answer++
                continue
            }
            if ()

        }
        return 0
    }
}