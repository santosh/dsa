package sort;

import java.util.Arrays;
import java.util.Random;

public class Quick {
    public static int pivotIndex(int[] arr, int start, int end) {
        int pivotValue = arr[end];
        int pivotIndex = start-1;  // initial value of pivotValue index

        for (int i=start; i<end; i++) {
            if (arr[i] < pivotValue) {
                pivotIndex++;
                swap(arr, pivotIndex, i);
            }
        }
        pivotIndex++;
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    public static int pivotIndexRandomized(int[] arr, int start, int end) {
        Random random = new Random(); // Class in Java which can be used to generate random elements

        int randPivotIndex = random.nextInt(end-start)+start; // [ start , end ] randomly

        //Swap it with the last index

        swap(arr, randPivotIndex, end);

        int pivotValue = arr[end];
        int pivotIndex = start-1;  // initial value of pivotValue index

        for (int i=start; i<end; i++) {
            if (arr[i] < pivotValue) {
                pivotIndex++;
                swap(arr, pivotIndex, i);
            }
        }
        pivotIndex++;
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if(start >= end){
            return ;
        }

        int pi = pivotIndexRandomized(arr,start, end);

        quickSort(arr,start,pi-1);
        quickSort(arr,pi+1,end);
    }

    private static void swap(int[] arr, int p, int i) {
        int temp = arr[p];
        arr[p] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 8, 3, 0, 2, 1, 4};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
