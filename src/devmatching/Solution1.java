package devmatching;
import java.util.*;

public class Solution1 {
    public int solution(String p, String s) {
        int answer = 0;
        char[] eachP= p.toCharArray();
        char[] eachS= s.toCharArray();
        for (int i = 0; i < eachP.length; i++) {
            int password = Integer.parseInt( Character.toString(eachP[i]));
            int find = Integer.parseInt( Character.toString(eachS[i]));
            int a = (Math.min(password,find) + 10) - Math.max(password,find);
            int b = Math.abs(password-find);
            answer += Math.min(a,b);
        }
        return answer;
    }
}
