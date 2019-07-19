package 카카오예선;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 브라이언의고민 {
    public String solution(String sentence) {
        String answer = "";
        char[] sentenceList;
        int flag = 0;

        sentenceList = sentence.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        Queue<Character> decision = new LinkedList<>();

        for (int i = 0; i < sentenceList.length; i++) {
            if (upperCase(sentenceList[i])) {
                list.add(sentenceList[i]);
            } else if (lowerCase(sentenceList[i])) {
                if (flag == 0) {
                    decision.offer(sentenceList[i]);
                } else if (decision.peek() != sentenceList[i]){
                    answer = "invalid";
                    break;
                }
            }

        }


        return answer;
    }

    private boolean upperCase(char a) {
        if (a >= 65 && a <= 90) {
            return true;
        } else {
            return false;
        }
    }

    private boolean lowerCase(char b) {
        if (b >= 97 && b <= 122) {
            return true;
        } else {
            return false;
        }
    }
}