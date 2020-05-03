package 백준.sort

import java.util.*
import kotlin.Comparator

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val queue: PriorityQueue<Exam> = PriorityQueue(Comparator<Exam> { p0, p1 ->
        //국어 점수 기준 내림차순
        if (p0.korean > p1.korean) -1
        //점수 같으면
        else if (p0.korean == p1.korean) {
            //영어 점수 기준 오름차순
            if (p0.english > p1.english) 1
            //점수 같으면
            else if (p0.english == p1.english) {
                //수학 점수 기준 내림차순
                if (p0.math > p1.math) -1
                //점수 같으면
                else if (p0.math == p1.math) {
                    //이름 기준 오름차순
                    if (p0.name > p1.name) 1
                    else -1
                } else 1
            } else -1
        } else 1
    })
    for (i in 0 until n) {
        val row = br.readLine().split(" ")
        queue.add(Exam(row[0], row[1].toInt(), row[2].toInt(), row[3].toInt()))
    }
    while (!queue.isEmpty()) {
        val q = queue.poll()
        println("${q.name}")
    }
    bw.flush()
}

data class Exam(
        val name: String,
        val korean: Int,
        val english: Int,
        val math: Int
)