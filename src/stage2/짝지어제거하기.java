package stage2;

import java.util.Stack;

public class 짝지어제거하기 {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> list = new Stack<>();
        list.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (list.isEmpty()) {
                list.push(s.charAt(i));
            }else if (list.peek() == s.charAt(i)) {
                list.pop();
            }else {
                list.push(s.charAt(i));
            }
        }

        if (list.isEmpty()) {
            answer =1;
        }
        return answer;
    }
}
//처음 생각했던 알고리즘
//        StringBuffer word = new StringBuffer(s);
//        int index =0;
//        boolean exist = true;
//        while (exist) {
//            if (word.charAt(index) != word.charAt(index+1)) {
//                index++;
//            }else {
//                word.delete(index,index+2);
//                index = 0;
//            }
//            if (word.length()==0) {
//                answer =1;
//                exist = false;
//            }
//        }
