package 카카오예선;

public class 컬러링북 {
    boolean[][] pathWay;
    int[][]
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;



        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
// 풀이법
//    int[][] copyPicture;
//    boolean[][] pathWay;
//    int maxSize =1;
//
//    public int[] solution(int m, int n, int[][] picture) {
//        pathWay = new boolean[m][n];
//        copyPicture = picture;
//
//        int numberOfArea = 0;
//        int maxSizeOfOneArea = 0;
//        int maxSizes =0;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (!pathWay[i][j] && picture[i][j] != 0) {
//                    numberOfArea++;
//                    maxSizes = findPath(i, j);
//                    System.out.println(maxSizes);
//                    if (maxSizes > maxSizeOfOneArea) {
//                        maxSizeOfOneArea = maxSizes;
//                    }
//                }
//            }
//        }
//
//        int[] answer = new int[2];
//        answer[0] = numberOfArea;
//        answer[1] = maxSizeOfOneArea;
//        return answer;
//    }
//
//    public int findPath(int i, int j) {
//        pathWay[i][j] = true;
//        if (i > 0 && !pathWay[i - 1][j] && copyPicture[i - 1][j] == copyPicture[i][j]) {
//            maxSize += findPath(i - 1, j);
//        }
//        if (i + 1 < pathWay.length && !pathWay[i + 1][j] && copyPicture[i + 1][j] == copyPicture[i][j]) {
//            maxSize += findPath(i+1, j);
//        }
//        if (j > 0 && !pathWay[i][j - 1] && copyPicture[i][j - 1] == copyPicture[i][j]) {
//            maxSize += findPath(i, j-1);
//        }
//        if (j + 1 < pathWay[i].length && !pathWay[i][j + 1] && copyPicture[i][j + 1] == copyPicture[i][j]) {
//            maxSize += findPath(i, j + 1);
//        }
//        return maxSize;
//    }