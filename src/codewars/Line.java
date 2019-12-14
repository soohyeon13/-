package codewars;

public class Line {
    public static String WhoIsNext(String[] names, int n){
        //같은 방법 이지만 줄일 수 있다.
        //반대의 생각
        while ( n > names.length){
            n = (n - (names.length - 1)) / 2;
        }
        return names[n-1];
    }
}

    // 나의 풀이
    // 문제를 작게 분홰해서 풀기
    /*public static String WhoIsNext(String[] name, int n) {
        int loop = 1;
        int len = name.length;
        int index = len * loop;

        while (n > index) {
            n -= index;
            loop *=2;
            index = len * loop;
        }
        n = (int) Math.ceil((double) n/loop);
        return name[n-1];
    }*/