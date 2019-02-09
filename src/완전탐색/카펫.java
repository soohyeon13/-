package 완전탐색;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class 카펫 {
    public int[] solution(int brown, int red) {
        int[] answer = {};
        int a = 0, b = 0;
        Deque<Integer> redArr = new LinkedList<>();
        ArrayList<Integer> redCommon = new ArrayList<>();
        for (int i = 1; i <= red; i++) {
            if (red % i == 0) {
                redArr.add(i);
            }
        }

        while (!redArr.isEmpty()) {

            if (redArr.size() >= 2) {
                a = redArr.pollLast();
                b = redArr.pollFirst();
            } else if (redArr.size() == 1) {
                a = redArr.poll();
                b = a;
            }
            if (brown == (2 * (a + b) + 4)) {
                redCommon.add(a + 2);
                redCommon.add(b + 2);
                break;
            } else {
                a = 0;
                b = 0;
            }
        }
        answer = new int[redCommon.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = redCommon.get(i);
        }


        return answer;
    }
}