package stack;

/*
Given a string that contains only the following => ‘{‘, ‘}’, ‘(‘, ‘)’, ‘[’, ‘]’. At some places there is ‘X’ in place of any bracket. Determine whether by replacing all ‘X’s with appropriate bracket, is it possible to make a valid bracket sequence.

Prerequisite: Balanced Parenthesis Expression
*/
public class IsExpressionBalanced {
    public static boolean isBalancedExpression(String str, java.util.Stack<Character> elementStack, int ind) {
        if (ind == str.length()) {
            return elementStack.isEmpty();
        }
        char c = str.charAt(ind);
        if (c == '{' || c == '(' || c == '[') {
            elementStack.push(c);
        } else if (c == '}' || c == ')' || c == ']') {
            if (elementStack.isEmpty()) {
                return false;
            }
            char top = elementStack.pop();
            if (c == '}' && top != '{' || c == ')' && top != '(' || c == ']' && top != '[') {
                return false;
            }
        } else if (c == 'X') {
            if (elementStack.isEmpty()) {
                return false;
            }
            char top = elementStack.pop();
            if (top == '{' || top == '(' || top == '[') {
                elementStack.push(top);
            } else {
                return false;
            }
        }
        return isBalancedExpression(str, elementStack, ind + 1);
    }

    public static void main(String[] args) {
        // String str = "{(X[X])}"
        String str = "{(X}[]"; // false
        System.out.println(isBalancedExpression(str, new java.util.Stack<>(), 0));
    }
}

