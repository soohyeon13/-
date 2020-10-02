package 카카오인턴2020

private val operatorPrioritys = arrayOf(arrayOf("+", "-", "*"),
        arrayOf("+", "*", "-"),
        arrayOf("*", "-", "+"),
        arrayOf("*", "+", "-"),
        arrayOf("-", "*", "+"),
        arrayOf("-", "*", "+"))
private val expressions = ArrayList<String>()
private var resultMaximum = 0
class MaximumOperator {
    fun solution(expression: String): Long {
        serializeExpression(expression)
        for (operator in operatorPrioritys) {
            calculateOperator(operator)
        }
        return 0
    }

    private fun serializeExpression(expression: String) {
        val sb = StringBuilder()
        for (index in 0 until expression.length) {
            val expressionChar = expression[index]
            if (expressionChar.toInt() in 48..57) {
                sb.append(expressionChar)
            }else {
                expressions.add(sb.toString())
                expressions.add(expressionChar.toString())
                sb.setLength(0)
            }
        }
        expressions.add(sb.toString())
    }

    private fun calculateOperator(operatorPriority : Array<String>) {
        for (i in operatorPriority) {

        }
    }
}