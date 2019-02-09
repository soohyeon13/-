package 나라124;

import java.util.ArrayList;

public class Country {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        String[] a = {"1", "2", "4"};

        if (n > 3){
            n--;
        }
        int k = 1;
        while (k <= n) {
            k *= 3;
        }

        k = k / 3;

        while (k != 0) {
            answer.append(a[n / k -1]);
            n %= k;
            k /= 3;
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        Country co =new Country();
        int a = 3;
        for (int i = 0; i < 20; i++) {
            System.out.println(co.solution(i));
        }


    }
}
