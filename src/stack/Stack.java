package stack;

import linkedlist.ListNode;

class StackUsingArray {
    private int[] arr;  // to hold data
    private int capacity;  // total capacity of array
    private int top;  // index of the last element added

    public StackUsingArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top = -1;  // initially thereis no element
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity-1;
    }

    public void push(int data) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }

        this.arr[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new StackOverflowError("Stack is empty");
        }

        return this.arr[top--];
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow exception");
        }

        return arr[this.top];
    }
}

class StackUsingLinkedList {
    private ListNode head = null;

    public void push(int data) {
        ListNode l = new ListNode(data);
        l.setNext(head);
        this.head = l;
    }

    public int pop() {
        if (isEmpty()) {
            throw new StackOverflowError("Stack is empty");
        }

        int data = this.head.getData();

        this.head = this.head.getNext();

        return data;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow exception");
        }

        return this.head.getData();
    }
}


public class Stack {
    public static void main(String[] args) {
//        StackUsingArray sa = new StackUsingArray(10);
//        sa.push(1);
//        sa.push(2);
//        sa.pop();
//        sa.top();

        StackUsingLinkedList sa = new StackUsingLinkedList();
        System.out.println(sa.isEmpty());
        sa.push(1);
        sa.push(2);
        System.out.println(sa.top());
        System.out.println(sa.pop());
        System.out.println(sa.top());
        System.out.println(sa.isEmpty());

//        sa.pop();
//        sa.top();
    }
}
