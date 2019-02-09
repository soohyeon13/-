package 탐욕법;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] a = new int[n + 2];

        for (int i = 0; i < reserve.length; i++) {
            a[reserve[i]] = 2;
        }
        for (int i = 0; i < lost.length; i++) {
            if (a[lost[i]] == 0) {
                a[lost[i]] = 1;
            } else if (a[lost[i]] == 2) {
                a[lost[i]] = 3;
            }
        }
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] == 0) {
                a[i] = 3;
            }
            if (a[i] == 2 && a[i - 1] == 1) {
                a[i - 1] = 3;
                a[i] = 3;
            } else if (a[i] == 2 && a[i + 1] == 1) {
                a[i] = 3;
                a[i + 1] = 3;
            }
        }
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] == 3 || a[i] == 2) {
                answer++;
            }
        }
        return answer;
    }
}