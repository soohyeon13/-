package 카카오2020

class WordSearching {
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        var answer = intArrayOf()
        val trieArr1 = Array<Trie>(10001){Trie(Array<Trie?>(26){null})}
        val trieArr2 = Array<Trie>(10001){Trie(Array<Trie?>(26){null})}
        var map = mutableMapOf<String, Int>()
        words.forEach {
            val len = it.length
            trieArr1[len].insert(it, 0)
            trieArr2[len].insert(it.reversed(), 0)
        }

        queries.forEach {
            val str = if(it[0] == '?') it.reversed() else it
            if(it[0] == '?') {
                val t = trieArr2[str.length].search(str, 0)
                answer += t
            }else {
                val t = trieArr1[str.length].search(str, 0)
                answer += t
            }
        }
        return answer
    }
}
class Trie(val tries: Array<Trie?>) {
    var count = 0
    fun insert(p: String, index: Int) {
        if(index == p.length) {
            return
        }
        count++
        val next = p[index].toInt() - 'a'.toInt()
        if(tries[next] == null) {
            tries[next] = Trie(Array<Trie?>(26){null})
        }
        tries[next]?.insert(p, index + 1)
    }
    fun search(p: String, index: Int): Int {
        if(index == p.length) {
            return 1
        }
        var result = 0
        if(p[index] == '?') {
            result = count
        }else {
            val next = p[index].toInt() - 'a'.toInt()
            result = tries[next]?.search(p, index + 1) ?: 0
        }
        return result
    }
}