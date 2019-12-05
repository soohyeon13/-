package codewars;


//미해결
public class ASum {
    public static long findNb(long m) {
        long sum =0;
        long index = 0;
        while (sum <m) {
            index++;
            sum += Math.pow(index,3);

        }
        if (sum ==m) return index;
        else return -1;
    }
}
