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
            int sum =0;
            numList = new int[index];
            for (int j = 0; j < numList.length; j++) {
                int num = scanner.nextInt();
                numList[j] = num;
            }
            list.offer(numList[numList.length-1]);

            for (int j = numList.length-2; j >= 0; j--) {
                if (list.peek() > numList[j]) {
                    list.offer(numList[j]);
                    int a =list.peek();
                    sum += (a-numList[j]);
                }else {
                    list.clear();
                    list.offer(numList[j]);
                }
            }
            System.out.println("#"+(i+1) + " " + sum);
            list.clear();
        }
    }
}
