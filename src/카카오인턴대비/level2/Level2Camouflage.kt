package 카카오인턴대비.level2

class Level2Camouflage {
    fun solution(clothes: Array<Array<String>>): Int =
            clothes.groupBy { it[1] }
                    .values
                    .fold(1) { acc, v -> acc * (v.size + 1) } - 1

}