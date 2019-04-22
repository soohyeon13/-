package 동적계획법;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] max_List = new int[len][len];
        int max = 0;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    max_List[i][j] = triangle[i][j] + triangle[i - 1][j];
                    triangle[i][j] = max_List[i][j];
                } else if (i == j) {
                    max_List[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
                    triangle[i][j] = max_List[i][j];
                } else {
                    max_List[i][j] = triangle[i][j] + Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                    triangle[i][j] = max_List[i][j];
                }
            }
        }

        for (int i = 0; i < len; i++) {
            max = Math.max(max, max_List[len - 1][i]);
        }
        answer = max;

        return answer;
    }
}
