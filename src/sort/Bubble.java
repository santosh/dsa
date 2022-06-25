package sort;

import linkedlist.DLLNode;
import linkedlist.DoublyLinkedList;

import java.util.Arrays;

public class Bubble {
    static boolean isSorted = false;
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i <= arr.length-1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void enhancedBubbleSort(int[] arr) {
        for (int i = 0; i <= arr.length-1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void bubbleSortRecursive(int[] arr, int n) {
        if (n<=1) {
            return;
        }


        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        bubbleSortRecursive(arr, n-1);
    }

    public static void enhancedBubbleSortRecursive(int[] arr, int n) {
        if (n<=1 || isSorted) {
            return;
        }

        isSorted = true;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                isSorted = false;
            }
        }

        bubbleSortRecursive(arr, n-1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

//        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));
        enhancedBubbleSortRecursive(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}

class BubbleSortDLL {


    static DLLNode bubbleSort(DLLNode head)
    {
        int swapped, i;
        DLLNode ptr1;
        DLLNode lptr = null;

        if (head == null)
            return null;

        do
        {
            swapped = 0;
            ptr1 = head;

            while (ptr1.getNext() != lptr)
            {
                if (ptr1.getData() > ptr1.getNext().getData())
                {
                    int t = ptr1.getData();
                    ptr1.setData(ptr1.getNext().getData());
                    ptr1.getNext().setData(t);
                    swapped = 1;
                }
                ptr1 = ptr1.getNext();
            }
            lptr = ptr1;
        }
        while (swapped != 0);
        return head;
    }

    public static void main(String[] args) {
        DLLNode node1 = new DLLNode(3);
        DLLNode node2 = new DLLNode(2);
        DLLNode node3 = new DLLNode(1);
        DLLNode node4 = new DLLNode(5);
        DLLNode node5 = new DLLNode(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        node2.setPrev(node1);
        node3.setPrev(node2);
        node4.setPrev(node3);
        node5.setPrev(node4);

        DoublyLinkedList.traverse(node1);

        DoublyLinkedList.traverse(bubbleSort(node1));
    }
}

// Stable: Yes
// Worst Time Complexity: O(n^2)
// Best Time Complexity: O(n^2)
// Number of comparison: O(n^2)
// Number of swap: O(n^2)
// Remark: Modified bubble sort can be used  for nearly sorted array.
//         Modified bubble sort can also be used to check if an array is sorted.