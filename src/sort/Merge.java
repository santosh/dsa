package sort;

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
