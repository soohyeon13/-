package sw1;

import java.util.Scanner;

public class Solution2071 {
    public static void main(String[] args) {
        int num, index;
        Scanner scan = new Scanner(System.in);
        index = scan.nextInt();
        for (int i = 0; i < index; i++) {
            int avg = 0;
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                num = scan.nextInt();
                sum += num;
            }
            avg = sum / 10;
            System.out.println("#" + (i + 1) + avg);
        }
    }
}
