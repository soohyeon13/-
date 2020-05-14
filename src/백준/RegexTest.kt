package 백준

fun main() {
    val word = "<br>aaaa</br> &quot; hello world "
    //특정 테그 내용 가져오기
//    val regex = "(?s)<.*br.*?>(.*?)</.*?br.*?>".toRegex()
    val test = word
            .replace("<br>", "")
            .replace("</br>","")
            .replace("&quot;","")
//    val regex = "(?<=(<))\\w*(?=>)".toRegex()
    println(test)
}