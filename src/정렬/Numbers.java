package 정렬;

import java.util.Arrays;
import java.util.Comparator;
public class Numbers {
    public static String solution(int[] numbers) {

        boolean all_zero = true;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] != 0){
                all_zero = false;
                break;
            }
        }
        if(all_zero) return "0";

        int len = numbers.length;

        String[] nums = new String[len];
        for(int i=0; i<len; i++){
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1.concat(o2);
                String str2 = o2.concat(o1);
                int v1 = Integer.parseInt(str1);
                int v2 = Integer.parseInt(str2);

                if(v1 > v2) return -1;
                else if(v1 == v2) return 0;
                else return 1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}
