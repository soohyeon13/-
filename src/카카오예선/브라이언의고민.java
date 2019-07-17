package 카카오예선;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 브라이언의고민 {
    public String solution(String sentence) {
        String answer = "";
        char[] sentenceList;
        int index =0;
        ArrayList<Character> word = new ArrayList<>();
        Queue<Character> firstRule = new LinkedList<>();
        Queue<Character> secondRule = new LinkedList<>();

        sentenceList = sentence.toCharArray();

        for (int i = 0; i < sentenceList.length; i++) {
            if (upperCase(sentenceList[i])) {
                word.add(sentenceList[i]);
                index++;
            }else {
                if (index ==0) {
                    secondRule.offer(sentenceList[i]);
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