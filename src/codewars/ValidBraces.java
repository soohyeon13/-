package codewars;

import java.util.Stack;

public class ValidBraces {
    public static boolean isValid(String braces) {
        Stack<String> brace = new Stack<>();

        for (int i = 0; i < braces.length(); i++) {
            if (braces.charAt(i) == '[' || braces.charAt(i) == '{' || braces.charAt(i) == '(') {
                brace.push(String.valueOf(braces.charAt(i)));
            }else {
                if (brace.isEmpty()){
                    return false;
                }
                else {
                    if (brace.peek().equals("[") && braces.charAt(i) == ']') {
                        brace.pop();
                    }
                    else if (brace.peek().equals("{") && braces.charAt(i) == '}'){
                        brace.pop();
                    }
                    else if (brace.peek().equals("(") && braces.charAt(i) == ')'){
                        brace.pop();
                    }
                    else return false;
                }
            }
        }
        if (brace.isEmpty()) {
            System.out.println("비어있습니다." + brace.isEmpty());
        }
        if (brace.isEmpty()) return true;
        else return false;
    }
}
