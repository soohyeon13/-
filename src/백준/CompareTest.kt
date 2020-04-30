package 백준

import java.util.*
import javax.swing.SwingUtilities
import kotlin.Comparator

fun main() {
    val queue : PriorityQueue<Student> =
            PriorityQueue(Comparator<Student> { p0, p1 ->
                if (p0.age > p1.age) 1
                else if (p0.age < p1.age) -1
                else {
                    if (p0.name < p1.name) 1
                    else -1
                }
            })
    queue.add(Student("aa",4))
    queue.add(Student("aa",2))
    queue.add(Student("bb",6))
    queue.add(Student("cc",3))
    queue.add(Student("dd",2))
    queue.add(Student("ee",7))
    queue.add(Student("ff",6))
    queue.add(Student("gg",4))
    queue.add(Student("hh",2))
    queue.add(Student("ii",7))
    queue.add(Student("jj",8))
    queue.add(Student("kk",9))
    println(queue.toString())
}
data class Student(
        val name : String,
        val age : Int
)