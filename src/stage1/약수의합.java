package stage1;

public class 약수의합 {
    public int solution(int n) {
        int answer = 0;
        int half = n/2;
        int sum =0;

        for (int i = 1; i <= half; i++) {
            if (n%i == 0) {
                sum +=i;
            }
        }
        sum += n;
        answer =sum;
        return answer;
    }
}