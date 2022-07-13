package stack;

import java.util.Stack;

public class KthLargestElement {
    public static int kthLargestElement(Stack<Integer> unsortedStack, int k) {
        Stack<Integer> sortedStack = sortDecending(unsortedStack);

        for (int i = 0; i < k - 1; i++) {
            sortedStack.pop();
        }

        return sortedStack.peek();
    }

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


    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        stack.push(1);

        System.out.println(kthLargestElement(stack, 2));
    }
}
