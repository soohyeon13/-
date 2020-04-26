package 카카오인턴대비.level3

import kotlin.time.measureTime

class Level3FindLoad {
    private var index = 0
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val arr = ArrayList<Tree>()
        for (i in nodeinfo.indices) {
            val x = nodeinfo[i][0]
            val y = nodeinfo[i][1]
            arr.add(Tree(x,y,i+1))
        }
        val sortArr =arr
                .sortedWith(compareByDescending<Tree> { it.x }.thenBy { it.y })
        println(sortArr.toString())
        val root = sortArr[0]
        val answer = Array(2){IntArray(sortArr.size)}
        for (i in 1 until sortArr.size) {
            checkChildNode(root,sortArr[i])
        }
        preorder(answer,root)
        index = 0
        postorder(answer,root)
        return answer
    }
    private fun preorder(answer: Array<IntArray>, root: Tree) {
        answer[0][index++] = root.position
        root.left?.let { preorder(answer,it) }
        root.right?.let { preorder(answer,it) }
    }
    private fun postorder(answer: Array<IntArray>, root: Tree) {
        root.left?.let { postorder(answer,it) }
        root.right?.let { postorder(answer,it) }
        answer[1][index++] = root.position
    }
    private fun checkChildNode(root: Tree?, child: Tree) {
        if (root!!.x > child.x) {
            if (root.left == null) {
                root.left = child
            }else {
                checkChildNode(root.left,child)
            }
        }else  {
            if (root.right == null) {
                root.right = child
            }else {
                checkChildNode(root.right,child)
            }
        }
    }

    data class Tree(
            val x: Int,
            val y: Int,
            val position: Int,
            var left: Tree? = null,
            var right: Tree? = null
    )
}