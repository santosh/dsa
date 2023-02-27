package pqueue;

import java.util.PriorityQueue;
public class PriorityQueueBasics {
    public static void main(String[] args) {
        // Creating a priority queue
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        PriorityQueue<String> myStr = new PriorityQueue<>();

        // Let us use the add() method
        numbers.add(10);
        numbers.add(23);
        numbers.add(55);
        System.out.println("Priority Queue is: " + numbers);

        // Let us use offer() method
        numbers.offer(40);
        System.out.println("Updated Priority Queue is: " + numbers);

        // Adding strings to the PQ
        myStr.add("hello");
        myStr.add("world");
        myStr.add("hello");
        System.out.println("myStr is: " + myStr);

        // Accessing PQ elements using peek() method
        int num = numbers.peek();
        System.out.println("Accessed element is: " + num);
    }
}
