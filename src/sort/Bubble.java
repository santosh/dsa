package sort;

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

// Stable: Yes
// Worst Time Complexity: O(n^2)
// Best Time Complexity: O(n^2)
// Number of comparison: O(n^2)
// Number of swap: O(n^2)
// Remark: Modified bubble sort can be used  for nearly sorted array.
//         Modified bubble sort can also be used to check if an array is sorted.