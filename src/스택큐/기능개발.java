package 스택큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int a,b;
        int c =0;
        int count=0;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> count_list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            a = 100-progresses[i];
            b = a/speeds[i] + (a%speeds[i] >0 ?1: 0);
            list.add(b);
        }
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(list.get(0));

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) <= qu.peek()) {
                qu.offer(list.get(i));
            }
            if (list.get(i) > qu.peek()) {
                while (!qu.isEmpty()) {
                    qu.poll();
                    count++;
                }
                count_list.add(count);
                qu.offer(list.get(i));
                count=0;
            }
        }
        if (!qu.isEmpty()) {
            count =0;
            while (!qu.isEmpty()) {
                qu.poll();
                count++;
            }
            count_list.add(count);
        }
        answer = new int[count_list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = count_list.get(i);
        }

        return answer;
    }
}
