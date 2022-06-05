package sort;

import java.util.Arrays;

public class Bubble {
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

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}

// Stable: Yes
// Worst Time Complexity: O(n^2)
// Best Time Complexity: O(n^2)
// Remark: Modified bubble sort can be used  for nearly sorted array.
//         Modified bubble sort can also be used to check if an array is sorted.