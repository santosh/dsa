package stack;

import java.util.Stack;

public class ReverseTheStack {
    private static void reverse(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) {
            return;
        }

        int data = stack.pop();
        reverse(stack);
        insertAtBottom(data, stack);
    }

    private static void insertAtBottom(int data, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        int element = stack.pop();
        insertAtBottom(data, stack);
        stack.push(element);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
