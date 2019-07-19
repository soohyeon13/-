package sw1;

import java.util.Scanner;

public class Solution2072 {
    public static void main(String[] args) {
        int num;
        int index;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        index = scanner.nextInt();
        for (int i = 0; i < index; i++) {
            sum =0;
            for (int j = 0; j < 10; j++) {
                num = scanner.nextInt();
                if (num % 2 != 0) {
                    sum += num;
                }
            }
            System.out.println("#" + (i + 1) + sum);
        }
    }
}
