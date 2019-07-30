package sw1;

import java.io.*;
import java.util.StringTokenizer;

public class Solution7964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cityNum = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());
            int[] cityList = new int[cityNum];
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < cityList.length; j++) {
                cityList[i] = Integer.parseInt(st.nextToken());
            }
            int num = 0;
            int index=cityList.length-1;
            for (int j = cityList.length-1; j >=0; j--) {
                if (cityList[j] == 1) {
                    index -= limit;
                } else if (cityList[j] == 0 && (index < j)) {
                    continue;
                }else {
                    num++;
                    index = j-limit;
                }
            }
            bw.write("#" + i + " " + num + "\n");
        }
        bw.close();
        br.close();
    }
}
