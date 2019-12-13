package codewars;

public class MergedStringChecker {
    public static boolean isMerge(String s, String part1, String part2){
        int part1Index = 0;
        int part2Index = 0;
        boolean part1Check = true;
        boolean part2Check = true;
        System.out.println(s);
        System.out.println(part1);
        System.out.println(part2);
        System.out.println(s.isEmpty());
        if (s.isEmpty() || (part1.isEmpty() && part2.isEmpty())) {
            return false;
        }
        if (s.length() != part1.length()+part2.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (part1Check && s.charAt(i) == part1.charAt(part1Index)) {
                part1Check = (part1Index != part1.length()-1) ? true : false;
                part1Index++;
                continue;
            }
            if (part2Check && s.charAt(i) == part2.charAt(part2Index)){
                part2Check = (part2Index != part2.length()-1) ? true : false;
                part2Index++;
            }
        }
        return !part1Check && !part2Check;
    }
}
