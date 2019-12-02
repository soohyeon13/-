package 카카오2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
    public long[] solution(long k, long[] room_number) {
        long[] answer = {};
        ArrayList<Long> list = new ArrayList<>();
        boolean[] check = new boolean[(int)k];
        for (int i = 0; i < room_number.length; i++) {
            if (!check[(int) (room_number[i]-1)]) {
                list.add(room_number[i]);
                check[(int) (room_number[i]-1)] = true;
            }else {
                for (int j = (int)room_number[i]; j < check.length; j++) {
                    if (!check[j]) {
                        list.add((long)(j+1));
                        check[j] = true;
                        break;
                    }
                }
            }
        }
        answer = new long[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
