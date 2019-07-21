package sw1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1859 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        Queue<Integer> list = new LinkedList<>();

        int[] numList;

        for (int i = 0; i < testCase; i++) {
            int index = scanner.nextInt();
            numList = new int[index];
            int num = scanner.nextInt();
            list.add(num);
            for (int j = 1; j < numList.length; j++) {
                num = scanner.nextInt();
                if (list.peek() > num) {
                    list.poll();
                }else if (list.peek() <= num) {

                }
            }
        }
    }
}
