package 카카오인턴대비.level3

import kotlin.test.assertNotSame

class Level3BadUser {
    private val badUsers = ArrayList<ArrayList<String>>()
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val visited = Array(user_id.size) { false}
        dfs(user_id, banned_id, 0, 0, visited)
        return badUsers.size
    }

    private fun dfs(userId: Array<String>, bannedId: Array<String>, index: Int, count: Int, visited: Array<Boolean>) {
        if (bannedId.size == count) {
            val temp = ArrayList<String>()
            for (i in visited.indices) {
                if (visited[i]) {
                    temp.add(userId[i])
                }
            }
            var cnt = 0
            for (i in badUsers.indices) {
                val u = badUsers[i]
                var flag = false
                for (j in temp.indices) {
                    if (!temp.contains(u[j])) flag = true
                }
                if (flag) cnt++
            }
            if (cnt == badUsers.size) {
                badUsers.add(temp)
            }
            return
        }else {
            for (i in userId.indices) {
                val find = bannedId[index].replace('*','.').toRegex()
                val userFind = find.matches(userId[i])
                if (userFind && userId[i].length == bannedId[index].length) {
                    if (!visited[i]) {
                        visited[i] = true
                        dfs(userId,bannedId,index+1,count+1,visited)
                        visited[i] = false
                    }
                }
            }
        }
    }
}