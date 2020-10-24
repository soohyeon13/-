package nhn코테;

import java.util.ArrayList;
import java.util.Collections;

public class Solution2 {
    public static void main(String[] args) {
        int[][] aa = {{6, 12, 0, 2, 8, 4, 0, 7, 3, 6}, {6, 1, 3, 0, 2, 8, 0, 0, 13, 8}, {6, 3, 0, 10, 6, 5, 7, 0, 0, 3}};
        solution(3, 10, aa);
    }

    private static void solution(int day, int width, int[][] blocks) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            arr.add(0);
        }
        int sum = 0;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                arr.set(j, arr.get(j) + blocks[i][j]);
                sum += blocks[i][j];
            }
            int cnt = 1;
            int index = 0;
            boolean leftFlag = false;
            boolean rightFlag = false;
            int max = Collections.max(arr);
            while (true) {
                if (cnt > max) break;
                if (index == width-1) cnt+=1;
                index %= width;
                if (arr.get(index) < cnt) {
                    for (int j = index; j >= 0; j--) {
                        if (arr.get(j) > arr.get(index)) {
                            leftFlag =true;
                            break;
                        }
                    }
                    for (int j = index; j < width ; j++) {
                        if (arr.get(j) > arr.get(index)) {
                            rightFlag =true;
                            break;
                        }
                    }
                    if (leftFlag && rightFlag) {
                        arr.set(index, arr.get(index) +1);
                    }
                    leftFlag = false;
                    rightFlag = false;
                }
                index +=1;
            }
        }
        int b = 0;
        for (int i = 0; i < arr.size(); i++) {
            b += arr.get(i);
        }
        System.out.println(b - sum);
    }
}