package 윈터코딩2018;

import java.util.HashMap;

public class 방문길이 {

    public int solution(String dirs) {
        int answer = 7;
        String[] order = dirs.split("");

        boolean[][][][] route = new boolean[11][11][11][11];


        for (int i = 0; i < order.length; i++) {
            if (order[i].equals("U")) {

            }else if (order[i].equals("L")) {

            }else if (order[i].equals("R")) {

            }else if (order[i].equals("D")) {

            }
        }
        return answer;
    }
}
