package 카카오2020

import java.util.*
import kotlin.collections.ArrayList

class LoadSearching {
    private var index = 0
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val nodes = ArrayList<Node>()
        for (i in nodeinfo.indices) {
            nodes.add(Node(nodeinfo[i][0],nodeinfo[i][1],i+1))
        }
        Collections.sort(nodes, Comparator<Node> { n1, n2 ->
            //y 기준 내림차순 정렬
            if (n1.y > n2.y) return@Comparator -1
            else if(n1.y<n2.y) return@Comparator 1
            else {
                //y 같다면 x기준 오름차순 정렬
                if (n1.x > n2.x) return@Comparator 1
                else if(n1.x < n2.x) return@Comparator  -1
                else return@Comparator 0
            }
        })
        var root = nodes[0]
        val answer = Array(2){IntArray(nodes.size)}
        for (i in 1 until nodes.size) {
            addNode(root,nodes[i])
        }
        preorder(answer,root)
        index = 0
        postorder(answer,root)
        for (i in answer.indices) {
            println(answer[i].contentToString())
        }
        return answer
    }

    private fun postorder(answer: Array<IntArray>, root: Node) {
        root.left?.let { postorder(answer,it) }
        root.right?.let { postorder(answer,it) }
        answer[1][index++] = root.position
    }

    private fun preorder(answer: Array<IntArray>, root: Node) {
        answer[0][index++] = root.position
        root.left?.let { preorder(answer, it) }
        root.right?.let { preorder(answer, it) }
    }

    private fun addNode(root: Node, node: Node) {
        if (root.x > node.x) {
            if (root.left == null) {
                root.left = node
            }else {
                addNode(root.left!!,node)
            }
        }else {
            if (root.right == null) {
                root.right = node
            }else {
                addNode(root.right!!,node)
            }
        }
    }
}

data class Node(
        val x: Int,
        val y: Int,
        val position : Int,
        var left: Node? = null,
        var right: Node? = null
)