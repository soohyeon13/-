package 동적계획법;

public class 타일장식물 {

    long[] cache = new long[81];

    public long solution(int N) {
        long answer = 0;

        answer = 4 * fibo(N) + 2 * fibo(N - 1);

        return answer;
    }

    private long fibo(int a) {
        if (a <= 2) {
            return 1;
        }
        if (cache[a] != 0) {
            return cache[a];
        } else {
            cache[a] = fibo(a - 1) + fibo(a - 2);
            return cache[a];
        }
    }
}
