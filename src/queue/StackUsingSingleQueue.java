package queue;

import java.util.Scanner;

public class StackUsingSingleQueue {
    public static class Node {
        private int data;
        private Node next;
        Node(int data) {
            super();
            this.data = data;
        }
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    public static class Queue {
        Node head;
        Node tail;
        private int currentSize; // number of items
        public Queue() {
            super();
            head = null;
            tail = null;
            currentSize = 0;
        }
        public boolean isEmpty() {
            return head == null;
        }
        public void enQueue(int data) {
            Node node = new Node(data);
            if (tail == null) {
                tail = node;
                head = node;
            } else {
                tail.setNext(node);
                tail = tail.getNext();
            }
            currentSize++;
        }
        public int deQueue() {
            int data = head.getData();
            head = head.getNext();
            if (head == null) { // it means it has got empty
                tail = null;
            }
            currentSize--;
            return data;
        }
        public int peek(){
            return head.data;
        }

        public int size(){
            return currentSize;
        }
    }

    Queue q = new Queue();
    /* Push operation of stack using queue*/
    void push(int x) {
        // get previous size of queue
        int size = q.size();

        // Add current element
        q.enQueue(x);

        for (int i = 0; i < size; i++) {
            x = q.deQueue();
            q.enQueue(x);
        }
    }

    /*Removes the top element of the stack*/
    int pop() {
        if (q.isEmpty()) {
            System.out.println("No elements");
            return -1;
        }
        return q.deQueue();
    }

    /*Returns the element at the top of the stack */
    int top() {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }

    boolean isEmpty() {
        return q.isEmpty();
    }
    public static void main(String[] args) {
        StackUsingSingleQueue obj = new StackUsingSingleQueue();
        Scanner in = new Scanner(System.in);
        /*Enter the number of elements you want to add in the stack */
        int n = in .nextInt();
        /*Enter the elements of the stack */
        for (int i = 0; i < n; i++) {
            obj.push( in .nextInt());
        }
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
    }
}