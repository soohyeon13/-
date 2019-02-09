package 정렬;

import java.util.ArrayList;
import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] list = {};
        for (int i = 0; i < commands.length; i++) {
            list = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(list);
            answer[i] = list[commands[i][2]-1];
        }
        return answer;
    }
}
