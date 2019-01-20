package io.zipcoder;

import java.util.stream.Collectors;

public class LeetUtils {

    public static Character numToLetter(Character c) {
        switch (c) {
            case '0':
                return 'o';
            case '1':
                return 'l';
            case '3':
                return 'e';
            case '4':
                return 'a';
            case '5':
                return 's';
            case '7':
                return 't';
            default:
                return c;

        }
    }

    public static String capitalizeMe(String s) {
        return Character.toUpperCase((s.charAt(0))) + s.substring(1);
    }

    public static String l33TToString(String cookies) {
        StringBuilder letterString = new StringBuilder();

        for (int i = 0; i < cookies.length(); i++) {
            letterString.append(LeetUtils.numToLetter(cookies.charAt(i)));
        }
        return letterString.toString();
    }

    public static String sameCase(String s) {
        StringBuilder result =  new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            result.setCharAt(i, ch >= 'A' && ch <= 'Z' ? (char) (ch + 'a' - 'A') : ch);
        }

        return result.toString();
    }

    public static String fullManipulate(String s) {
        return sameCase(l33TToString(s));
    }

    public static String stringFormatName(String name, int count) {
        String time = (count > 1) ? "times" : "time";
        return (String.format("name: %7s%6sseen: %d " + time, capitalizeMe(name), "", count));
    }

    public static String stringFormatPrice(Double price, int count, String label1, String label2) {
        String time = (count > 1) ? "times" : "time";
        return String.format("%7s%6.2f%5s%7s%d " + time + "\n",label1 + ": ", price,"",label2 + ": ", count);
    }

    public static String errorLine(int count) {
        String time = (count > 1) ? "times" : "time";
        return (String.format("%s%19s%2d " + time, "Errors", "seen: ", count));
    }

    public static String doubleLine() {
        return (String.format("\n%8s%6s%8s\n", "=============", "", "============="));
    }

    public static String singleLine() {
        return (String.format("%8s%6s%8s\n\n", "-------------", "", "-------------"));
    }

}
