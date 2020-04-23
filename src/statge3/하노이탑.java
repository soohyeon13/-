package statge3;

import java.util.ArrayList;
import java.util.List;

public class 하노이탑 {
    public int[][] solution(int n) {
        int[][] answer = {};
        ArrayList<int[]> route = new ArrayList<>();
        int first = 1;
        int second = 2;
        int third = 3;
        hanoi(first, second, third, n,route);
        return route.toArray(new int[route.size()][]);
    }

    private void hanoi(int first, int second, int third, int n,ArrayList<int[]> route) {
        if (n == 1) {
            route.add(new int[]{first,third});
        } else {
            hanoi(first,third,second,n-1,route);
            route.add(new int[]{first,third});
            hanoi(second,first,third,n-1,route);
        }
    }
}
