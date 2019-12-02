package 이분탐색;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 예산 {
    public int solution(int[] budgets, int M) {
        int max = IntStream.of(budgets).max().getAsInt();
        int min = 0,temp = 0,avg;
        long sum = IntStream.of(budgets).sum();
        if (sum <= M) return max;
        while (true) {
            avg = (max + min) / 2;
            sum = 0;
            for (int budget : budgets) sum += Math.min(avg, budget);

            if (avg == temp) return avg;

            if (sum > M) max = avg;
            else min = avg;

            temp = avg;
        }
    }
}
