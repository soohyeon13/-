package nhn코테연습;

import java.util.ArrayList;

public class 모의고사 {
    private static final int[] first = {1, 2, 3, 4, 5};
    private static final int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % 5]) score[0]++;
            if (answers[i] == second[i % 8]) score[1]++;
            if (answers[i] == third[i % 10]) score[2]++;
        }
        int maxScore = Math.max(score[0],Math.max(score[1],score[2]));
        ArrayList<Integer> answer = new ArrayList<>();
        if (maxScore == score[0]) answer.add(1);
        if (maxScore == score[1]) answer.add(2);
        if (maxScore == score[2]) answer.add(3);
        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}
