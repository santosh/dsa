package array;

import java.util.Arrays;

public class Reverse {
    public static int[] iterative(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;

            l++;
            r--;
        }

        return arr;
    }

    public static void recursive(int[] arr, int start, int end) {
        int temp;

        if (start >= end)
            return;

        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        recursive(arr, start+1, end-1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 9};
        // System.out.println(Arrays.toString(iterative(arr)));
        recursive(arr, 0, arr.length -1);

        System.out.println(Arrays.toString(arr));
    }
}
