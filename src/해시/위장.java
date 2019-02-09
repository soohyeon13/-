package 해시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 위장 {
    public int cloth(String[][] clothes) {
        int answer = 0;
        int clothNum = clothes.length;
        HashMap<String,Integer> clothMap = new HashMap<>();
        ArrayList<String> clothKind = new ArrayList<>();
        for (int i = 0; i < clothNum; i++) {
            clothKind.add(clothes[i][1]);
        }
        Collections.sort(clothKind);

        int count =0;
        String kind = clothKind.get(0);
        for (int i = 0; i < clothKind.size(); i++) {
            if (kind.equals(clothKind.get(i))) {
                count++;
            }else {
                clothMap.put(kind,count);
                count = 1;
                kind = clothKind.get(i);
            }
        }
        clothMap.put(kind,count);

        int number =1;
        for (int a:clothMap.values()) {
            number *= a+1;
        }
        answer = number-1;
        return answer;
    }
}

