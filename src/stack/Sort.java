package stack;

import java.util.Stack;

public class Sort {
    public static Stack<Integer> sortDecending(Stack<Integer> unsortedStack) {
        Stack<Integer> sortedStack = new Stack<Integer>();
        while (!unsortedStack.isEmpty()) {
            int current = unsortedStack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > current) {
                unsortedStack.push(sortedStack.pop());
            }
            sortedStack.push(current);
        }
        return sortedStack;
    }

    public static Stack<Integer> sort(Stack<Integer> unsortedStack) {
        Stack<Integer> sortedStack = new Stack<Integer>();
        while (!unsortedStack.isEmpty()) {
            int current = unsortedStack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() < current) {
                unsortedStack.push(sortedStack.pop());
            }
            sortedStack.push(current);
        }
        return sortedStack;
    }

    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new Stack<>();

        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(4);

        System.out.println(stack);
//        System.out.println(sortDecending(stack));
        System.out.println(sort(stack));
    }
}
