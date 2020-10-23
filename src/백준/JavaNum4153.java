package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JavaNum4153 {
    private static final String RIGHT = "right";
    private static final String WRONG = "wrong";

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] arr = input.readLine().split(" ");
            int[] a = new int[arr.length];
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
                if (a[i] == 0) {
                    flag = true;
                }
            }
            if (flag) break;
            Arrays.sort(a);
            if (a[2] * a[2] == ((a[0] * a[0]) + (a[1] * a[1]))) {
                System.out.println(RIGHT);
            } else {
                System.out.println(WRONG);
            }
        }
    }
}
