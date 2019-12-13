package codewars;

public class PigLatin {
    public static String pigIt(String str) {
        String[] word = str.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length; i++) {
            if (word[i].equals("!") || word[i].equals("?")) {
                sb.append(word[i]);
                continue;
            }
            else {
                sb.append(word[i].substring(1)).append(word[i].charAt(0)).append("ay");
            }
            if (i != word.length-1) sb.append(" ");
            System.out.println(sb.toString());
        }
        return String.valueOf(sb);
    }
}
