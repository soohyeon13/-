package 스택큐;

import java.util.LinkedList;
import java.util.Queue;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer;
        int time = 0;
        int index1 = 1;
        int first_price;
        Queue<Integer> q_prices = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            q_prices.add(prices[i]);
        }

        first_price = q_prices.poll();

        while (!q_prices.isEmpty()) {
            if (index1 == prices.length) {
                time = 0;
                break;
            }
            for (int i = index1; i < prices.length; i++) {
                if (first_price <= prices[i]) {
                    time += 1;
                } else if (first_price > prices[i]) {
                    time += 1;
                    break;
                }
            }
            first_price = q_prices.poll();
            list.add(time);
            time = 0;
            index1++;
        }
        list.add(time);
        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }


        return answer;
    }
}