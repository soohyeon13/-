package 힙;

import java.util.Collections;
import java.util.PriorityQueue;

public class 라면공장 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int index1 = 0;
        int weight = stock;
        int index2 = 0;
        PriorityQueue<Integer> supp_pq= new PriorityQueue(Collections.reverseOrder());
        while (weight <k) {
            for (int i = index2; i < dates.length; i++) {
                if (dates[i] <=weight) {
                    supp_pq.offer(supplies[i]);
                    index1 =i;
                }
            }
            index2 = index1 + 1;
            weight += supp_pq.poll();
            answer++;
        }
        return answer;
    }
}
