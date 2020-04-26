package statge3

class Best {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val genresPlayScoreMap = mutableMapOf<String,Int?>()
        for (i in genres.indices) {
            if (!genresPlayScoreMap.containsKey(genres[i])) genresPlayScoreMap[genres[i]] = plays[i]
            else genresPlayScoreMap[genres[i]] = genresPlayScoreMap[genres[i]]?.plus(plays[i])
        }
        val a =genresPlayScoreMap.toList().sortedByDescending { (_,value) -> value }
        val result = mutableListOf<Int>()
        println(a.toString())
        for (i in a.indices) {
            val mutableList = mutableMapOf<Int,Int>()
            for (j in genres.indices) {
                if (genres[j] != a[i].first) continue
                mutableList[j] = plays[j]
            }
            val b =
                    mutableList
                            .toList()
                            .sortedByDescending { (_,value) -> value }
                            .groupBy { (key,_) -> key }
                            .toList()
            var count =2
            loop@for (k in b.indices) {
                if(count == 0) break@loop
                for (j in b[k].second.indices) {
                    if (count == 0) break@loop
                    result.add(b[k].second[j].first)
                    count -=1
                }
            }
        }
        return result.toIntArray()
    }
}