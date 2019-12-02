package codewars;

import java.util.Arrays;

public class SquareDigit {
    public int squareDigits(int n) {
        StringBuilder sb = new StringBuilder();
        String sn = String.valueOf(n);
        String[] num = sn.split("");

        for (int i =num.length-1 ; i >=0; i--) {
            sb.append((int)Math.pow(Integer.parseInt(num[i]),2));
        }
        return Integer.parseInt(sb.toString());
    }

}
