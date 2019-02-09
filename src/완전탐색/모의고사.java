package 완전탐색;

import java.util.ArrayList;
import java.util.LinkedList;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] result = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) result[0] += 1;
            if (answers[i] == two[i % 8]) result[1] += 1;
            if (answers[i] == three[i % 10]) result[2] += 1;
        }
        int maxResult = Math.max(result[0],Math.max(result[1],result[2]));
        if (maxResult == result[0]) arr.add(1);
        if (maxResult == result[1]) arr.add(2);
        if (maxResult == result[2]) arr.add(3);
        answer = new int[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
