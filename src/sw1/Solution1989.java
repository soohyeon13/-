package sw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String word;
        for (int i = 0; i < T; i++) {
            word = br.readLine();
            int result = 1;
            int index = word.length() - 1;
            for (int j = 0; j < word.length() / 2; j++) {
                if (j == index) {
                    break;
                }
                if (word.charAt(j) != word.charAt(index)) {
                    result = 0;
                }
                index--;
            }
            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
