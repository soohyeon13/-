package 카카오블라인드2021

class Solution1 {
    fun solution(new_id: String): String {
        var answer = ""
        val firstStepNewId = new_id
                .toLowerCase()
                .toCharArray()
                .map { it.toInt() }
        var secondStepNewId = firstStepNewId
                .filter { it in 97..122 || it in 45..46 || it == 95 || it in 48..57 }
                .joinToString(separator = ",") { it.toChar().toString() }
                .replace(",", "")
                .replace("..", ".")

        while (true) {
            if (secondStepNewId.contains("..")) {
                secondStepNewId = secondStepNewId.replace("..", ".")
            } else {
                break
            }
        }
        var thirdStepNewId = secondStepNewId
                .removePrefix(".")
                .removeSuffix(".")
        println(thirdStepNewId)
        if (thirdStepNewId.isBlank()) {
            thirdStepNewId = "a"
        }
        val fourthStepNewId = StringBuilder()
        var fifthStepNewId = ""
        if (thirdStepNewId.length >= 16) {
            println(thirdStepNewId)
            for (i in 0 until 15) {
                fourthStepNewId.append(thirdStepNewId[i])
            }
            fifthStepNewId = fourthStepNewId.toString().removePrefix(".")
                    .removeSuffix(".")
            answer = isCheckLen(fifthStepNewId)
        } else {
            answer = isCheckLen(thirdStepNewId)
        }
        return answer
    }

    private fun isCheckLen(word: String): String {
        val lastStepNewId = StringBuilder()
        var lastChar = word[word.length - 1]
        if (word.length <= 2) {
            for (i in 0 until word.length - 1) {
                lastStepNewId.append(word[i])
            }
            while (true) {
                if (lastStepNewId.length == 3) break
                lastStepNewId.append(lastChar)
            }
            return lastStepNewId.toString()
        } else {
            return word
        }
    }
}