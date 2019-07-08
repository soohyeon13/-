package 섬머코딩2017;

public class 소수만들기 {
    int flag;

    public int solution(int[] nums) {
        int answer = -1;
        int len = nums.length;
        int sum;
        int count = 0;

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (decimal(sum) == 1) {
                        count++;
                    }
                }
            }
        }
        answer = count;

        return answer;
    }

    private int decimal(int sum) {
        int index = sum / 2;

        for (int i = 2; i <= index; i++) {
            if (sum % i == 0) {
                flag = 0;
                break;
            } else {
                flag = 1;
            }
        }
        return flag;
    }
}