package sw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine());
        String[] numList = new String[test];
        String result = "";
        for (int i = 0; i <test ; i++) {
            numList[i] = String.valueOf(i+1);
        }
        for (String a :
                numList) {
            String b = "";
            if (a.contains("3")) {
                b = a.replaceAll("3", "-");
                b = b.replaceAll("[0-9]","");
            }else if (a.contains("6") ) {
                b =a.replaceAll("6", "-");
                b = b.replaceAll("[0-9]","");
            }else if (a.contains("9")) {
                b =a.replaceAll("9", "-");
                b = b.replaceAll("[0-9]","");
            }else {
                b = a;
            }
            result += b + " ";
        }
        System.out.println(result);
    }
}
