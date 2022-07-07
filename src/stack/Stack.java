package stack;

import linkedlist.ListNode;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingArray {
    private int[] arr;  // to hold data
    private int capacity;  // total capacity of array
    private int top;  // index of the last element added

    public StackUsingArray(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top = -1;  // initially there is no element
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

class StackUsingQueue {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int data){
        // Q1  -> Q2
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        // Insert the data in Q1
        q1.add(data);

        // Insert the data from Q2 to Q1
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
    }

    public int pop(){
        if(q1.isEmpty()){
            throw new RuntimeException("Stack underflow exception");
        }
        int data = q1.remove();
        return data;
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
