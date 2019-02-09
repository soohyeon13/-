package 해시;

public class 전화번호 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[i].startsWith(phone_book[j])) {
                    answer = false;
                    break;
                }
                if (phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
