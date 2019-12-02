package 카카오2020;

public class Solution5 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int count = 0;
        while (count < k) {
            answer++;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] != 0) {
                    stones[i] -= 1;
                    count =0;
                }else {
                    count++;
                }
                if (count == k) {
                    break;
                }
            }
        }
        return answer-1;
    }
}
