package stage1;

public class a2016 {
    public String solution(int a, int b) {
        String answer = "";
        String[] days = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = 2016;
        int daySum;

        daySum = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;

        for (int i = 0; i < a - 1; i++) {
            daySum += month[i];
        }
        daySum += b;

        int result;

        result = daySum%7;

        answer = days[result];

        return answer;
    }
}
