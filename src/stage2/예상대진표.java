package stage2;

public class 예상대진표 {
    public int solution(int n, int a, int b) {
        int answer;
        int round = 1;
        boolean connect = true;
        while (connect) {
            if (a < b && b - a == 1 && a/2 != b/2) {
                break;
            } else if (b < a && a - b == 1 && a/2 != b/2) {
                break;
            }
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            round++;

        }

        answer = round;
        return answer;
    }
}
