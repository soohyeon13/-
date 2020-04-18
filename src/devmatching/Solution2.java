package devmatching;

import java.util.Arrays;

public class Solution2 {
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private final int[] four = {0,1,2,3};
    private int[] arr = new int[2];
    private int cnt = 0;

    public int solution(int[][] office, int r, int c, String[] move) {
        cnt += office[r][c];
        office[r][c] =0;
        arr[0] = r;
        arr[1] = c;
        int state = 0;
        for (int i = 0; i < move.length; i++) {
            if (move[i].equals("right") || move[i].equals("left")) {
                state = direction(state, move[i]);
            }else  {
                check(state, arr, office);
            }
        }
        return cnt;
    }

    public void check(int state, int[] start, int[][] office) {
        int x = start[0] + dx[state];
        int y = start[1] + dy[state];
        int len = office.length;
        if (x < 0 || y < 0 || x >= len || y >= len) {
            return;
        }
        if (office[x][y] == -1) {
            return;
        } else {
            cnt += office[x][y];
            office[x][y] = 0;
        }
        arr[0] = x;
        arr[1] = y;
    }

    public int direction(int state, String progress) {
        switch (progress) {
            case "go": {
                break;
            }
            case "right": {
                state = (state +1) %4;
                break;
            }
            case "left": {
                if (state == 0) {
                    state =3;
                }else  {
                    state -=1;
                }
                break;
            }
        }
        return four[state];
    }
}
