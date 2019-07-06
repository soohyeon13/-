package stage1;

public class 문자열정수 {
    public int solution(String s) {
        int answer = 0;
        int result = 0;
        String remain= "";
        String firstChar = String.valueOf(s.charAt(0));
        if (firstChar == "-") {
            remain = s.substring(1);
            result = Integer.valueOf(remain) * -1;
        } else {
            remain = s;
            result = Integer.valueOf(remain);
        }

        answer = result;
        return answer;
    }
}
