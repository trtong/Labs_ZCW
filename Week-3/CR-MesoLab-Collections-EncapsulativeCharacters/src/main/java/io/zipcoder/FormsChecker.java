package io.zipcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FormsChecker {

    public static boolean formChecker(String s) {
        Map<Character, Character> pairs = new HashMap<Character, Character>();

        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');
        pairs.put('<', '>');

        Stack<Character> stack =  new Stack<Character>();
        for (Character c: s.toCharArray()) {
            if (pairs.containsKey(c)) {
                stack.push(pairs.get(c));
            } else if (c == '\'' || c == '\"') {
                if (stack.isEmpty() || stack.peek() != c) {
                    stack.push(c);
                } else {
                    stack.pop();
                }
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
