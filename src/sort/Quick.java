package sort;

import linkedlist.LinkedList;
import linkedlist.ListNode;

import java.util.Arrays;
import java.util.Random;

public class Quick {
    public static int pivotIndex(int[] arr, int start, int end) {
        int pivotValue = arr[end];
        int pivotIndex = start-1;  // initial value of pivotValue index

        for (int i=start; i<end; i++) {
            if (arr[i] < pivotValue) {
                pivotIndex++;
                swap(arr, pivotIndex, i);
            }
        }
        pivotIndex++;
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    public static int pivotIndexRandomized(int[] arr, int start, int end) {
        Random random = new Random(); // Class in Java which can be used to generate random elements

        int randPivotIndex = random.nextInt(end-start)+start; // [ start , end ] randomly

        //Swap it with the last index

        swap(arr, randPivotIndex, end);

        int pivotValue = arr[end];
        int pivotIndex = start-1;  // initial value of pivotValue index

        for (int i=start; i<end; i++) {
            if (arr[i] < pivotValue) {
                pivotIndex++;
                swap(arr, pivotIndex, i);
            }
        }
        pivotIndex++;
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if(start >= end){
            return ;
        }

        int pi = pivotIndexRandomized(arr,start, end);

        quickSort(arr,start,pi-1);
        quickSort(arr,pi+1,end);
    }

    private static void swap(int[] arr, int p, int i) {
        int temp = arr[p];
        arr[p] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 8, 3, 0, 2, 1, 4};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}


class QuickSortLinkedList {


    static ListNode partitionLast(ListNode start, ListNode end)
    {
        if (start == end || start == null || end == null)
            return start;

        ListNode pivot_prev = start;
        ListNode curr = start;
        int pivot = end.getData();

        while (start != end) {
            if (start.getData() < pivot) {
                pivot_prev = curr;
                int temp = curr.getData();
                curr.setData(start.getData());
                start.setData(temp);
                curr = curr.getNext();
            }
            start = start.getNext();
        }

        int temp = curr.getData();
        curr.setData(pivot);
        end.setData(temp);

        return pivot_prev;
    }

    static void quickSort(ListNode start, ListNode end)
    {
        if(start == null || start == end|| start == end.getNext() )
            return;

        ListNode pivot_prev = partitionLast(start, end);
        quickSort(start, pivot_prev);

        if (pivot_prev != null && pivot_prev == start)
            quickSort(pivot_prev.getNext(), end);

        else if (pivot_prev != null
                && pivot_prev.getNext() != null)
            quickSort(pivot_prev.getNext().getNext(), end);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        LinkedList.traverse(head);

        quickSort(head,node5);
        LinkedList.traverse(head);


    }

}