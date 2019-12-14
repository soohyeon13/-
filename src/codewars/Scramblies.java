package codewars;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        //다른 풀이
        if (str1.length() < str2.length()) return false;
        for (String a :
                str2.split("")) {
            if (!str1.contains(a)) return false;
            str1 = str1.replaceFirst(a,"");
        }
        return true;
    }
}
/* 나의 풀이
    String[] str1List = str1.split("");
    String[] str2List = str2.split("");
    Arrays.sort(str1List);
    Arrays.sort(str2List);
    int index =0;
    for (int i = 0; i < str1List.length; i++) {
        if (index == str2.length()) return true;
        if (str1List[i].equals(str2List[index])) index++;
     }
     System.out.println(index);
     if (index < str2.length()) return false;*/
