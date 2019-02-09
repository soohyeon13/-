package 탐욕법;

import java.util.Arrays;
import java.util.LinkedList;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        LinkedList<Integer> lifeBoat = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            lifeBoat.add(people[i]);
        }
        int index = 0;
        int weight = lifeBoat.get(0);
        while (!lifeBoat.isEmpty()) {
            if (index == 2) {
                answer++;
                index = 0;
            }
            if (weight < limit) {
                weight += lifeBoat.poll();
                index += 1;
            }
            if (weight >= limit) {
                answer++;
            }
        }
        return answer;
    }

}
