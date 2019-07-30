package sw1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int num = Integer.parseInt(br.readLine());
            int sum = 0;
//            int[] a = new int[num];
            st = new StringTokenizer(br.readLine(), " ");
//            int index= a.length;
            for (int j = 0; j <num ; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

//            list = Arrays.stream(br.readLine().split(" "))
//                    .map(Integer::parseInt).collect(Collectors.toList());
            int b = list.get(num-1);
            System.out.println(b);
            for (int j = num- 2; j >= 0; j--) {
                if (b > list.get(j)) {
                    sum += b - list.get(j);
                } else {
                    b = list.get(j);
                }
            }
            list.clear();
            bw.write("#" + i + " " + sum + "\n");
        }
        bw.close();
        br.close();
    }
}
