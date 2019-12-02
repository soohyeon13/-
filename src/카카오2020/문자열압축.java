package 카카오2020;

public class 문자열압축 {
    public static void main(String[] args) {
        String a = "aabbaccc";
        solution(a);
    }
    public static int solution(String s) {
        int answer = 0;
        int halfLen = s.length() / 2;
        int len = s.length();
        String copy = "";

        for (int i = 1; i <= halfLen; i++) {
            StringBuilder overlap = new StringBuilder();
            int share = s.length() /i;
            int remain = (s.length() % i == 0) ? 0 : 1 ;
            int totalCnt = share + remain;
            int cnt = 0;
            int temp = 0;
            copy = s.substring(temp,temp+i);
            for (int j = 0; j < totalCnt; j++) {
                if (temp + i >= s.length()) {
                    if (temp > s.length()) {
                        break;
                    }
                    String test = s.substring(temp);
                    if (copy.equals(test)) {
                        cnt++;
                        overlap.append(cnt);
                        overlap.append(copy);
                    }else {
                        if (cnt == 1 || cnt == 0) {
                            overlap.append(copy);
                            overlap.append(test);
                        }else {
                            overlap.append(cnt);
                            overlap.append(copy);
                            overlap.append(test);
                        }

                    }

                } else {
                    String sub = s.substring(temp, temp + i);
                    if (copy.equals(sub)) {
                        cnt++;
                    } else {
                        if (cnt == 1 || cnt == 0) {
                            overlap.append(copy);
                        } else {
                            overlap.append(cnt);
                            overlap.append(copy);
                        }
                        cnt =1;
                    }
                    copy = sub;
                }
                temp += i;
            }
            if (len > overlap.length()) {
                len = overlap.length();
            }
        }

        answer = len;
        return answer;
    }
}
