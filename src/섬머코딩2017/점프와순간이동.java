package 섬머코딩2017;

public class 점프와순간이동 {
    public int solution(int n) {
        int ans = 0;
        while (true) {
            if (n == 1) {
                ans++;
                break;
           }
            if (n % 2 == 0) {
                n = n/2;
            } else {
                n = n-1;
                ans++;
            }
        }
        return ans;
    }
}
