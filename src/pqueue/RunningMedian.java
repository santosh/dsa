package pqueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//We will use 2 heaps to keep track of median
//We make sure that one of the following conditions is always true
//      1) maxHeap.size() == minHeap.size()
//      2) maxHeap.size() - 1 = minHeap.size()
public class RunningMedian {
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //keeps track of the SMALL numbers
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();                           //keeps the track of LARGE numbers

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the input array: ");
        int n = scan.nextInt();
        System.out.println("Enter the elements of input array: ");
        int [] array = new int[n];
        for (int i = 0; i <n ; i++)
        {
            array[i] = scan.nextInt();
        }
        scan.close();
        medianTracker(array);
    }

    //Let us define medianTracker function
    public static void medianTracker(int [] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            addNumber(array[i]);
            System.out.print("Median after reading element: " +array[i] + " is: " );
            System.out.print(getMedian() + "\n");
        }
    }

    //Let us define addNumber function
    private static void addNumber(int n)
    {
        if (maxHeap.isEmpty()){
            maxHeap.add(n);
        } else if (maxHeap.size() == minHeap.size()){
            if(n < minHeap.peek()){
                maxHeap.add(n);
            } else {
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
        } else if (maxHeap.size() > minHeap.size()){
            if(n > maxHeap.peek()){
                minHeap.add(n);
            } else {
                maxHeap.add(n);
                minHeap.add(maxHeap.remove());
            }
        }
        // maxHeap will never have fewer elements than minHeap
    }

    //Let us define getMedian() function
    private static double getMedian()
    {
        if (maxHeap.isEmpty())
        {
            return 0;
        } else if (maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else { //maxHeap must have more elements than minHeap
            return maxHeap.peek();
        }
    }
}
