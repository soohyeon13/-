package 카카오인턴대비.level3

class Level3BestAlbum {
    fun solution(genres: Array<String>,plays:IntArray):IntArray{
        val arr = genres.indices.groupBy { genres[it] }
        println(arr.toString())
        return genres.indices.groupBy { genres[it] }
                .toList()
                .sortedByDescending { it.second.sumBy { plays[it] } }
                .map { it.second.sortedByDescending { plays[it] }.take(2) }
                .flatten()
                .toIntArray()
    }
}