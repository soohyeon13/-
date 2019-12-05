package codewars;

public class BitCounting {
    public static int countBits(int n) {
        String bit = Integer.toBinaryString(n);
        int answer =0;
        for (int i = 0; i <bit.length() ; i++) {
            if (bit.charAt(i) == '1') {
                answer++;
            }

        }
        return answer;
    }
}
