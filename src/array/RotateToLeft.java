package array;

import java.util.*;

public class RotateToLeft {

    public static void main(String args[]) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        int d = 3;

        rotateArray(arr, n, d);
    }
    // Method to rotate array left by d elements
    static void rotateArray(int[] arr, int n, int d) {
        // Write your code here
        d %= n;

        int[] auxArr = new int[n];
        int auxArrIndex = 0;

        for (int i = d; i < arr.length; i++) {
            auxArr[auxArrIndex] = arr[i];
            auxArrIndex++;
        }

        for (int i = 0; i < d; i++) {
            auxArr[auxArrIndex] = arr[i];
            auxArrIndex++;
        }

        System.out.println(Arrays.toString(auxArr));
    }
}