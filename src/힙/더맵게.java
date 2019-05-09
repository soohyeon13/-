package 힙;

import java.util.*;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int firstLowScovile, secondLowScovile, newScovile;

        PriorityQueue<Integer> pqHotList = new PriorityQueue(scoville.length);

        for (int aScovile: scoville) {
            pqHotList.offer(aScovile);
        }

        if (pqHotList.peek() >=K) {
            answer = -1;
        }

        while (pqHotList.peek() < K) {

            if (pqHotList.size() == 1) {
                answer = -1;
                break;
            }
            firstLowScovile = pqHotList.poll();
            secondLowScovile = pqHotList.poll();

            newScovile = firstLowScovile + (secondLowScovile * 2);

            pqHotList.offer(newScovile);

            answer++;
        }
        return answer;
    }
}
