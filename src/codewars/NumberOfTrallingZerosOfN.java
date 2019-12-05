package codewars;

public class NumberOfTrallingZerosOfN {
    public static int zeros(int n) {
        System.out.println(n);
        int a = 0;
        int b =0;
        a = n/5;
        b= n/25;
        return a+b;
    }
}
