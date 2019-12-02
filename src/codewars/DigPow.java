package codewars;

public class DigPow {
    public static long digPow(int n,int p) {
        long sum =0;
        String[] numList = String.valueOf(n).split("");
        for (int i = 0; i <numList.length ; i++) {
            sum += Math.pow(Integer.parseInt(numList[i]),p);
            p++;
        }
        System.out.println(sum);
        if (p ==1 && n != sum) return -1;
        if (sum/n == 0) return sum/n;
        else return -1;
    }
}
