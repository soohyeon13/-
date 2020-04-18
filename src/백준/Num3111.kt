package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val key1 = br.readLine()
    val key = key1.toCharArray()
    var text = br.readLine().toCharArray()
    val left = Stack<Char>()
    val right = Stack<Char>()
    var start = 0
    var end = text.size-1
    var isRemove = false
    while (start <= end) {
        if (!isRemove) {
            left.push(text[start++])
            if (left.size >= key.size && left.peek() == key[key.size-1]) {
                var keyLen = key.size-1
                var check = true
                for (i in left.size-1 downTo left.size-key.size) {
                    if (left.get(i) != key[keyLen--]) {
                        check = false
                        break
                    }
                }
                if (check) {
                    isRemove = true
                    for (i in 0 until key.size) {
                        left.pop()
                    }
                }
            }
        }
        if (!isRemove && start <= end) {
            var keyRev = StringBuilder(key1).reverse().toString()
            right.push(text[end--])

        }
    }
    bw.flush()
}