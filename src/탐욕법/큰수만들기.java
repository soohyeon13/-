package 탐욕법;

public class 큰수만들기 {
    public String solution(String number, int k) {
        String answer = "";
        int numberLen = number.length();
        int wordNumber = number.length() - k;
        int endIndex = numberLen - wordNumber;
        int startIndex = 0;
        int temp = 0;

        char[] chWord = new char[wordNumber];
        char[] chNumber = new char[numberLen];

        for (int i = 0; i < numberLen; i++) {
            chNumber[i] = number.charAt(i);
        }
        char chStart = chNumber[0];
        for (int i = 0; i < wordNumber; i++) {
            for (int j = startIndex; j <= endIndex; j++) {
                if (chStart < chNumber[j]) {
                    chStart = chNumber[j];
                    temp = j;
                }
            }
            chWord[i] = chStart;
            if (temp != numberLen - 1) {
                chStart = chNumber[temp + 1];
            }
            startIndex = temp + 1;
            if (temp == startIndex-1) {
                temp++;
            }
            endIndex++;
        }
        answer = new String(chWord);
        return answer;
    }
}

// 이렇게 푸는 방법도 있구나...
/*
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
*/

