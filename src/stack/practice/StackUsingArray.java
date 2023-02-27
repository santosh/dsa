package stack.practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Stack {
    int top;
    private int arr[];

    Stack(int capacity) {
        arr = new int[capacity];
        top = -1;
    }
    public boolean isFull() {
        return top == this.arr.length-1;
    }

    void push(int val) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        this.arr[++top] = val;
    }

    int pop() {
        if (isEmpty()) {
            return -1;
        }

        return this.arr[top--];
    }

    int peek() {
        if (top < 0) {
            return -1;
        }
        return this.arr[top];
    }

    int size() {
        return top+1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
// Class name should be "Source",
// otherwise solution won't be accepted
public class StackUsingArray {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int maxCap = sc.nextInt();
        int querySize = sc.nextInt();
        Stack stack = new Stack(maxCap);
        ArrayList<Integer> result = new ArrayList<>();
        while(sc.hasNextLine() && querySize >= 0) {
            String[] cmd = sc.nextLine().split(" ");
            if(cmd[0].equals("push")) {
                stack.push(Integer.parseInt(cmd[1]));
            } else if(cmd[0].equals("peek")) {
                result.add(stack.peek());
            } else if(cmd[0].equals("pop")) {
                result.add(stack.pop());
            } else if(cmd[0].equals("size")) {
                result.add(stack.size());
            }
            querySize--;
        }
        for(int item: result) {
            System.out.println(item);
        }
    }
}