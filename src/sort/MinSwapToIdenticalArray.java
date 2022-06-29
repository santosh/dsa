package sort;

import java.util.Scanner;

public class MinSwapToIdenticalArray {
    public static int minimumSwap(int[] arr1, int[] arr2) {
        //Write your code here
        int swapCount = 0;

        // keeping first array as it is,
        // move the items in second array to match first array
        for (int i = 0; i < arr1.length; i++)
        {
            // if the index value is not same in both the arrays
            if (arr1[i] != arr2[i])
            {
                int j = i;

                // look for the same value in second array as
                // on i index of first array
                while (arr2[j] != arr1[i])
                {
                    j++;
                    // if j is going out of range and item is not found.
                }

                // swap the items on index i and j in second array
                // to match the i index with first array.
                swap(arr2, i, j);
                // increase the swap count.
                swapCount++;
            }
        }

        return swapCount;
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            arr2[i] = sc.nextInt();
        }
        int result = minimumSwap(arr1, arr2);
        System.out.println(result);
    }
}