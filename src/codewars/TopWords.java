package codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopWords {
    public static List<String> top3(String s) {
        List<String> wordList = new ArrayList<>();
        if (s.length() == 0) return wordList;
        HashMap<String,Integer> map = new HashMap<>();
        String[] word = s.toLowerCase().split(" ");
        for (int i = 0; i < word.length; i++) {
            if (!map.containsKey(word[i])) map.put(word[i],1);
        }
        return wordList;
    }
}
