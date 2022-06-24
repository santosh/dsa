package sort;

import linkedlist.LinkedList;
import linkedlist.ListNode;

import java.util.Arrays;

public class Merge {

    /**
     * Divide input array into half, recursively. While exiting from recursion,
     * we sort each chunk we have divided.
     * @param arr
     * @param start
     * @param end
     */
    public static void sort(int[] arr, int start, int end) {
        // Base case
        if (start >= end) {
            return;
        }

        int mid = start + (end - start)/2;

        // divide in half
        sort(arr, start, mid);
        sort(arr, mid+1, end);

        // conquer part
        merge(arr, start, mid, end);
    }

    /**
     * Array is sorted between start and mid,
     * array is also sorted between mid and end.
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[arr.length];
        int tempIndex = start;

        int leftStart = start;
        int rightStart = mid+1;

        while (leftStart <= mid && rightStart <= end) {
            if (arr[leftStart] < arr[rightStart]) {
                temp[tempIndex] = arr[leftStart];
                leftStart++;
            } else {
                temp[tempIndex] = arr[rightStart];
                rightStart++;
            }
            tempIndex++;
        }
        // If the elements in the left part is still left
        while (leftStart <= mid) {
            temp[tempIndex++] = arr[leftStart++];
        }
        // if the element in the right part is still available
        while (rightStart <= end) {
            temp[tempIndex++] = arr[rightStart++];
        }

        // copy the sorted temp array to original array
        for (int i=start; i<=end; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 8, 3, 0, 4, 9, 5, 7, 4, 8};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

class MergeLL {
    public static ListNode sortedMerge(ListNode a, ListNode b)
    {
        ListNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.getData() <= b.getData()) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b));
        }
        else {
            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
        }
        return result;
    }

    public static ListNode mergeSort(ListNode h) {
        // Base case : if head is null
        if (h == null || h.getNext() == null) {
            return h;
        }

        // get the middle of the list
        ListNode middle = getMiddle(h);
        ListNode nextofmiddle = middle.getNext();

        // set the next of middle node to null
        middle.setNext(null);

        // Apply mergeSort on left list
        ListNode left = mergeSort(h);

        // Apply mergeSort on right list
        ListNode right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        ListNode sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Utility function to get the middle of the linked list
    public static ListNode getMiddle(ListNode head) {
        if (head == null)
            return head;

        ListNode slow = head, fast = head;

        while (fast.getNext() != null && fast.getNext().getNext()!= null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.setNext(new ListNode(2));
        head.getNext().setNext(new ListNode(1));
        head.getNext().getNext().setNext(new ListNode(8));

        LinkedList.traverse(head);

        LinkedList.traverse(mergeSort(head));
    }
}