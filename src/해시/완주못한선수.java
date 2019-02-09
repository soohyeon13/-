package 해시;

import java.util.HashMap;

public class 완주못한선수 {
    public String nonPlayer(String[] participant, String[] completion) {
        String answer = "";
        int val = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        for (String name : participant) {
            if (hm.get(name) == null) {
                hm.put(name, 1);
            } else {
                val = hm.get(name) + 1;
                hm.put(name, val);
            }
        }
        for (String name : completion) {
            if (hm.get(name) != null) {
                val = hm.get(name) - 1;
                hm.put(name, val);
            }
        }
        for (String name :
                hm.keySet()) {
            if (hm.get(name) == 1) {
                answer = name;
            }
         }
        return answer;
    }
}
