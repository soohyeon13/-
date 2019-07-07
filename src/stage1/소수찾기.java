package stage1;

import java.util.ArrayList;

public class 소수찾기 {
    public int solution(int n) {
        int answer = 0;
        int count =1;

        ArrayList<Integer> primeNum = new ArrayList<>();
        primeNum.add(2);
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < primeNum.size(); j++) {
                if (i % primeNum.get(j) == 0) {
                    break;
                }
                if (j + 1 == primeNum.size()) {
                    primeNum.add(i);
                    count++;
                }
            }
        }

        answer = count;
        return answer;
    }
}