package codewars;

import java.util.ArrayList;
import java.util.Arrays;

public class MexicanWave {
    public static String[] wave(String str) {
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                continue;
            }
            StringBuilder sb = new StringBuilder(str);
            sb.setCharAt(i,Character.toUpperCase(str.charAt(i)));
            words.add(sb.toString());
        }
        return words.toArray(new String[0]);
    }
}
