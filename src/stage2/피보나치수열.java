package stage2;

public class 피보나치수열 {
    private int[] data = new int[100000];

    public int solution(int n) {
        int answer = 0;
        answer = fibo(n);
        return answer;
    }


    private int fibo(int n) {
        if (n <= 2) {
            return 1;
        }
        if (data[n] != 0) {
            return data[n];
        } else {
            data[n] = fibo(n - 2) % 1234567 + fibo(n - 1) % 1234567;
            return data[n]%1234567;
        }
    }
}