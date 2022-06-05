package sort;

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

// Stable: No
// Worst Time Complexity: O(n^2)
// Best Time Complexity: O(n^2)
// Number of comparison: O(n^2)
// Number of swap: O(n)