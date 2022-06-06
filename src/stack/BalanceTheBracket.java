package stack;

import java.util.Stack;

public class BalanceTheBracket {
    public static boolean isBalanced(char[] ac) {
        Stack<Character> sc = new Stack();

        for (int i = 0; i < ac.length; i++) {
            if (ac[i] == '{' || ac[i] == '(' || ac[i] == '[') {
                sc.push(ac[i]);
                System.out.println(sc);
            } else if (ac[i] == '}' || ac[i] == ')' || ac[i] == ']') {
                if (sc.isEmpty()) {
                    return false;
                }
                if (!isMatching(sc.peek(), ac[i])) {
                    return false;
                }
                sc.pop();
            }
        }
        if (sc.size() > 0) {
            return false;
        }
        return true;
    }

    private static boolean isMatching(Character open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        char[] arr = {'{', '[', ']', ')', '}'};

        System.out.println(isBalanced(arr));
    }
}
