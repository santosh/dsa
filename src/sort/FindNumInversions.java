package sort;

import java.util.Arrays;

/**
 * An inversion is a condition in which i < j, but arr[i] > arr[j].
 * Here both i and j are indexes of an array arr.
 */
public class FindNumInversions {
    public static int countInversions(int[] arr, int start, int end) {
        // Base case
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start)/2;

        // divide in half
        int inversionCountLeftHalf = countInversions(arr, start, mid);
        int inversionCountRightHalf = countInversions(arr, mid+1, end);

        // conquer part
        int inversionCountMerge = inversionCountDuringMerge(arr, start, mid, end);
        return inversionCountMerge+inversionCountLeftHalf+inversionCountRightHalf;
    }

    private static int inversionCountDuringMerge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[arr.length];

        int tempIndex = start;
        int leftStart = start;
        int rightStart = mid+1;
        int count = 0;

        while (leftStart <= mid && rightStart <= end) {
            if (arr[leftStart] < arr[rightStart]) {
                temp[tempIndex++] = arr[leftStart++];
            } else {
                // this is the case of inversion
                count = count + mid - leftStart + 1;
                temp[tempIndex++] = arr[rightStart++];
            }
        }

        // If the elements in the left part is still left
        while (leftStart <= mid) {
            temp[tempIndex++] = arr[leftStart++];
        }
        // if the element in the right part is still available
        while (rightStart <= end) {
            temp[tempIndex++] = arr[rightStart++];
        }

        for (int i=start; i<=end; i++) {
            arr[i] = temp[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 0, 0};

        System.out.println(Arrays.toString(arr1));

        int[] arr = {1, 20, 6, 4, 5};

        System.out.println(countInversions(arr, 0, arr.length - 1));
    }
}
