package 스택큐;

import java.util.Stack;

public class 쇠막대기 {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<Integer> st_arr = new Stack<>();

        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == '(') {
                st_arr.push(i);
            } else {
                st_arr.pop();
                if (arrangement.charAt(i - 1) == '(') {
                    answer += st_arr.size();
                } else {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
