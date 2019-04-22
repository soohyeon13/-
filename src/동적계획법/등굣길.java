package 동적계획법;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] route = new int[n][m];
        int len = puddles.length;
        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(route[i], -1);
        }

        for (int i = 0; i < len; i++) {
            y = puddles[i][0] - 1;
            x = puddles[i][1] - 1;
            route[x][y] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (route[i][j] == 0) continue;
                if (i == 0 && j == 0) {
                    route[i][j] = 1;
                } else if (i == 0) {
                    route[i][j] = route[i][j - 1] % 1000000007;
                } else if (j == 0) {
                    route[i][j] = route[i - 1][j] % 1000000007;
                } else {
                    route[i][j] = (route[i - 1][j] + route[i][j - 1]) % 1000000007;
                }
            }
        }

        answer = route[n-1][m-1];

        return answer;
    }
}
