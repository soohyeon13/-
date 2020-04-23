package 카카오인턴대비.level2

class Level2Draw {
    fun solution(n:Int,a:Int,b:Int):Int {
        var answer = 0
        var one = a
        var two = b
        while (one != two) {
            answer++
            if (one%2 == 0) one /= 2
            else one = one/2 +1
            if (two%2 == 0) two /= 2
            else two = two/2 +1
        }
        return answer
    }
}