package sort;

import linkedlist.DLLNode;
import linkedlist.DoublyLinkedList;

import java.util.Arrays;

public class Selection {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // find the smallest elements i--> end and swap it with ith index
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[min]) {
                    min=j;
                }
            }

            // min represent the index where there is mallest element
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(arr));

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}

class SelectionSortDLL {

    public static DLLNode selectionSort(DLLNode head)
    {
        DLLNode temp = head;

        while (temp!=null) {
            DLLNode min = temp;
            DLLNode r = temp.getNext();

            // Traverse the unsorted sublist
            while (r!=null) {
                if (min.getData() > r.getData())
                    min = r;

                r = r.getNext();
            }

            int x = temp.getData();
            temp.setData(min.getData());
            min.setData(x);
            temp = temp.getNext();
        }
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

        DoublyLinkedList.traverse(selectionSort(node1));
    }
}

// Stable: No
// Worst Time Complexity: O(n^2)
// Best Time Complexity: O(n^2)
// Number of comparison: O(n^2)
// Number of swap: O(n)