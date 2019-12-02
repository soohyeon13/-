package codewars;

import java.util.regex.Pattern;

class Kyu6ToCamelCaes {
    static String toCamelCase(String s) {
        return Pattern
                .compile("(-|_)([a-z]|[A-Z])")
                .matcher(s)
                .replaceAll(matchResult -> matchResult.group().toUpperCase())
                .replaceAll("(-|_)", "");
    }
}
