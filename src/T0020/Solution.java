package T0020;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        char[] flag_1 = new char[]{'(', ')'};
        char[] flag_2 = new char[]{'[', ']'};
        char[] flag_3 = new char[]{'{', '}'};

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == flag_1[1]) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() == flag_1[0]) {
                    continue;
                }
                return false;
            }
            if (c == flag_2[1]) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() == flag_2[0]) {
                    continue;
                }
                return false;
            }
            if (c == flag_3[1]) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() == flag_3[0]) {
                    continue;
                }
                return false;
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
