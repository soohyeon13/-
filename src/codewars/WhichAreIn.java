package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WhichAreIn {
    public static String[] inArray(String[] array1,String[] array2) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array2[j].contains(array1[i])) {
                    list.add(array1[i]);
                    break;
                }
            }
        }
        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }
}
