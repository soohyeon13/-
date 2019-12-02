package codewars;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        int verticalSum =0;
        int horizontalSum =0;
        if (walk.length != 10) return false;
        for (int i = 0; i <walk.length; i++) {
            switch (walk[i]) {
                case 'n':
                    verticalSum+=1;
                    break;
                case 's':
                    verticalSum-=1;
                    break;
                case 'e':
                    horizontalSum+=1;
                    break;
                case 'w':
                    horizontalSum-=1;
                    break;
            }
        }
        if (verticalSum ==0 && horizontalSum == 0) return true;
        else return false;
    }
}
