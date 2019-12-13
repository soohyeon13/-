package codewars;

import java.util.ArrayList;
import java.util.List;

public class GapInPrimes {
    public static long[] gap(int g, long m, long n) {
        long check = 0;
        List<Long> list1 = new ArrayList<>();
        for (long i = m; i <=n; i++) {
            if (IsPrime(i)){
                if (i - check == g) {
                    System.out.println(i);
                    list1.add(check);
                    list1.add(i);
                }
                check = i;
            }
        }
        System.out.println(list1.toString());
        long[] answer = new long[list1.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list1.get(i);
        }
        return answer;
    }

    private static boolean IsPrime(long prime) {
        for (long j = 2; j <prime; j++) {
            if (prime%j == 0) return false;
        }
        return true;
    }
}
