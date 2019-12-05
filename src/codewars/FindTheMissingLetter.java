package codewars;

public class FindTheMissingLetter {
    public static char findMissingLetter(char[] array) {
        char answer = ' ';
        for (int i = 0; i < array.length-1; i++) {
            int a = array[i+1] -array[i];
            if (a == 1 ||a == 0 ) {
                continue;
            }else {
                answer = (char)((int)array[i]+1);
            }
        }

        
        return answer;
    }
}

