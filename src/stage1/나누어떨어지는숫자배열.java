package stage1;

import java.util.PriorityQueue;

public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int num;
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                num = arr[i];
                pq.add(num);
            }
        }

        if (pq.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[pq.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = pq.poll();
            }
        }
        return answer;
    }
}