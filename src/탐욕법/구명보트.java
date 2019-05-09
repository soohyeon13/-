package 탐욕법;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int index = 0;
        int i = 0;
        Arrays.sort(people);

        for (i = people.length - 1; i >index; i--) {
            if (people[i] + people[index] <= limit) {
                index++;
                answer++;
            } else {
                answer++;
            }
        }

        if (i == index) {
            answer++;
        }
        return answer;
    }
}
