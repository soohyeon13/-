package codewars;

public class CommonDenominators {
    public static String convertFrac(long[][] lst) {
        long lcm = lst[0][1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < lst.length; i++) {
            lcm = getLcm(lcm,lst[i][1]);

        }
    }

    private static long getLcm(long lcm, long l) {
        if (lcm<=0 || l <= 0 ) return -1;
        return lcm*l/getGcd(lcm,l);
    }

    private static long getGcd(long lcm, long l) {
        int temp;
        while (l!=0) {
            temp = (int) l;
            l = lcm%l;
            lcm = temp;
        }
        return lcm;
    }
}
