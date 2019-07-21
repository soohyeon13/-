package 찾아라프로그래밍마에스터;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public int solution(int[][] maps) {
        int[] status = {0, 0};
        int[] dir_y = {-1, 1, 0, 0};
        int[] dir_x = {0, 0, -1, 1};

        int n = maps.length;
        int m = maps[0].length;
        int count = 0;

        Queue<int[]> q = new LinkedList<int[]>();
        q.add(status);

        boolean[][] visited = new boolean[n][m];

        while (!q.isEmpty()) {
            int qSize = q.size();
            count++;
            for (int i = 0; i < qSize; i++) {
                status = q.poll();
                int x = status[0];
                int y = status[1];
                if (maps[y][x] == 0) {
                    continue;
                }
                if (visited[y][x]) {
                    continue;
                }
                visited[y][x] = true;
                if (y == n - 1 && x == m - 1) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    int[] newStatus = {status[0] + dir_x[j], status[1] + dir_y[j]};
                    int nx = newStatus[0];
                    int ny = newStatus[1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                        q.add(newStatus);
                    }
                }
            }
        }


        return -1;
    }
}
