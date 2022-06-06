package sort;

import java.util.Arrays;

/**
 * Given an unsorted array, arrange the array element in such an order that
 * the order becomes a wave. i.e. increasing, decreasing, increasing, decreasing.
 */
public class SortInWaveOrder {
    public static void waveSort(int[] arr) {
        for (int i = 1; i < arr.length; i=i+2) {
            if (arr[i-1]<arr[i]) {
                int temp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = temp;
            }
            if (i+1<arr.length &&  arr[i+1]<arr[i]) {
                int temp = arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(arr));
        waveSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
