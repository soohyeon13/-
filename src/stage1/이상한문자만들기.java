package stage1;

public class 이상한문자만들기 {
    public String solution(String s) {
        String answer = "";
        int index = 0;
        char[] result = new char[s.length()];
        int uppercase;
        int lowercase;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                index = 0;
                result[i] = ' ';
                continue;
            }
            if ((int)s.charAt(i)>=97 && (int)s.charAt(i) <= 122 &&index % 2 == 0) {
                uppercase = (int) s.charAt(i) - 32;
                result[i] = (char) uppercase;
                index++;
            }else if (index %2 ==0) {
                result[i] = s.charAt(i);
                index++;
            }else if ((int) s.charAt(i) >= 65 && (int) s.charAt(i) <= 90) {
                lowercase = (int)s.charAt(i) +32;
                result[i] = (char)lowercase;
                index++;
            }else {
                result[i] = s.charAt(i);
                index++;
            }
        }

        answer = new String(result);
        return answer;
    }
}
