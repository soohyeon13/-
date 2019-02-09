package 힙;

import java.util.*;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int count =0;
        Queue<Integer> pq = new PriorityQueue<Integer>(scoville.length);
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        if (pq.peek() >=K) {
            count = -1;
        }
        while (pq.size()>1) {
           if (pq.peek()>=K) {
               answer = count;
               break;
           }
           int a = pq.poll();
           int b = pq.poll();
           int c = a+(b*2);
           pq.offer(c);
           count++;
        }
        if (pq.poll() >=K){
            answer = count;
        }


        return answer;
    }
}
