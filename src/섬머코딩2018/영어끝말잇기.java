package 섬머코딩2018;

import java.util.HashMap;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int index =0;
        char lastWord = ' ';
        char startWord = ' ';
        HashMap<String, Integer> map = new HashMap<>();
        map.put(words[0],1);
        for (int i = 0; i < words.length-1; i++) {
            lastWord = words[i].charAt(words[i].length()-1);
            startWord = words[i+1].charAt(0);
            if ((lastWord != startWord) || map.containsKey(words[i+1])) {
                if((i+2)%n==0){
                    answer[0] = n;
                    answer[1] =    (i+2)/n;
                    return answer;
                }else{
                    answer[0] = (i+2)%n;
                    answer[1] =    ((i+2)/n)+1;
                    return answer;
                }
            }else {
                map.put(words[i+1],(i+1)%n+1);
            }
        }
        return answer;
    }
}