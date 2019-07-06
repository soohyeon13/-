package stage1;

public class 시저암호 {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder word = new StringBuilder();
        int[] ascii = new int[s.length()];
        for (int i = 0; i < ascii.length; i++) {
            if (s.charAt(i) == 'z') {
                ascii[i] = 96 + n;
            } else if (s.charAt(i) == 'Z') {
                ascii[i] = 64 + n;
            } else if (s.charAt(i) == ' ') {
                ascii[i] = 32;
            } else {
                ascii[i] = (int) s.charAt(i) + n;
            }
            word.append((char) ascii[i]);
        }

        answer = word.toString();
        return answer;
    }
}

//또 다른 풀이
//
//    public String solution(String s, int n) {
//        String answer = "";
//        int z = (int)'z';
//        int Z = (int)'Z';
//        int a = (int)'a';
//        int A = (int)'A';
//        char[] temp = s.toCharArray();
//
//        for(int i =0; i<temp.length; i++){
//            if(temp[i]>=a&& temp[i]<=z){
//                temp[i] = (int)temp[i]+n > z ? (char)(a+(int)temp[i]+n-z-1) : (char)((int)temp[i]+n);
//            }else if(temp[i]>=A&& temp[i]<=Z){
//                temp[i] = (int)temp[i]+n > Z ? (char)(A+(int)temp[i]+n-Z-1) : (char)((int)temp[i]+n);
//            }else{
//                temp[i]=temp[i];
//            }
//        }
//        answer = new String(temp);
//        return answer;
//    }
//}

