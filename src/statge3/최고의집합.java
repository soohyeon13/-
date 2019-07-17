package statge3;

import java.util.ArrayList;
import java.util.Collections;

public class 최고의집합 {
    public int[] solution(int n, int s) {
        int[] answer = {};
        int num =0;
        ArrayList<Integer> list= new ArrayList<>();

        while (n >0) {
            if (n >s) {
                list.add(-1);
                break;
            }
            num = s/n;
            list.add(num);
            s -= num;
            n--;
        }
        Collections.sort(list);
        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
