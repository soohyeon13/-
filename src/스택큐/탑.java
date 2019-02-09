package 스택큐;

import java.util.ArrayDeque;
import java.util.Deque;

public class 탑 {
    public int[] tower(int[] heights) {
        int[] answer = {};
        int len = heights.length;
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = len -1; i>0; i--) {
            for (int j =i-1; j>=0; j--) {
                if (heights[i] <heights[j]) {
                    st.push(j+1);
                    break;
                }else if (j==0) st.push(0);
            }
        }
        st.push(0);
        answer = new int[st.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = st.pop();
        }
        return answer;
    }
}
