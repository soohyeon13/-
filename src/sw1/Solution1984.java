package sw1;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution1984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int min =10000;
            int max =0;
        }
//        List<Integer> list;
//        for (int i = 1; i <= T; i++) {
////            st = new StringTokenizer(br.readLine(), " ");
//            list = Arrays.stream(br.readLine().split(" "))
//                    .map(Integer::parseInt).collect(Collectors.toList());
//
//            Collections.sort(list);
//            list.remove(0);
//            list.remove(list.size() - 1);
//
//            int sum = 0;
//            for(int item : list) sum += item;
//            bw.write("#" + i + " " + Math.floorDiv(sum, 8) + "\n");
//        }

        bw.close();
        br.close();
    }
}
