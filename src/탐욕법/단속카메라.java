package 탐욕법;

import java.util.*;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        int count =0;
        int MIN = Integer.MIN_VALUE;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        for (int[] route : routes) {
            if (MIN < route[0]) {
                MIN = route[1];
                count += 1;
            }
        }
        answer = count;
        return answer;
    }
}
