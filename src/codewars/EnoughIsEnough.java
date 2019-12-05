package codewars;

import java.util.ArrayList;
import java.util.HashMap;

//미해결
public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (maxOccurrences == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            if (!map.containsKey(elements[i])) {
                map.put(elements[i], 1);
                list.add(elements[i]);
            } else {
                if (map.get(elements[i]) < maxOccurrences) {
                    map.put(elements[i], map.get(elements[i]) + 1);
                    list.add(elements[i]);
                }
            }
        }
        int[] num = new int[list.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = list.get(i);
        }
        return num;
//        return list.stream().mapToInt(i -> i).toArray();
    }
}
