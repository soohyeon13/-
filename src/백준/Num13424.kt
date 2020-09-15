package 백준

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val input = System.`in`.bufferedReader()
    val T = input.readLine().toInt()
    for (i in 0 until T) {
        val (N, M) = input.readLine().split(" ").map { it.toInt() }
        val secretMeetingMap = Array(N + 1) { ArrayList<SecretRoom>() }
        for (j in 0 until M) {
            val row = input.readLine().split(" ").map { it.toInt() }
            secretMeetingMap[row[0]].add(SecretRoom(row[1], row[2]))
            secretMeetingMap[row[1]].add(SecretRoom(row[0], row[2]))
        }
        val K = input.readLine().toInt()
        val friends = input.readLine().split(" ").map { it.toInt() }
        val friendsPathLen = Array(K) { ArrayList<Int>() }
        for (j in friends.indices) {
            val pathLen = getShortestPath(friends[j], N, secretMeetingMap)
            friendsPathLen[j] = pathLen
        }
        var sum = Int.MAX_VALUE
        var result = 0
        for (j in 1..N) {
            var copySum = 0
            for(k in friendsPathLen.indices) {
                copySum += friendsPathLen[k][j]
            }
            if (sum > copySum) {
                sum = copySum
                result = j
            }
        }
        println(result)
    }
}

private fun getShortestPath(end: Int, n: Int, secretMeetingMap: Array<ArrayList<SecretRoom>>): ArrayList<Int> {
    val queue: Queue<Friend> = LinkedList()
    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    queue.add(Friend(end, 0))
    dist[end] = 0
    while (!queue.isEmpty()) {
        val q = queue.poll()
        for (i in secretMeetingMap[q.end].indices) {
            val nNode = secretMeetingMap[q.end][i].end
            val nDist = secretMeetingMap[q.end][i].distance
            if (dist[nNode] > q.distance + nDist) {
                dist[nNode] = q.distance + nDist
                queue.add(Friend(nNode, dist[nNode]))
            }
        }
    }
    return dist.toCollection(ArrayList())
}

private data class Friend(
        val end: Int,
        val distance: Int
)

private data class SecretRoom(
        val end: Int,
        val distance: Int
)