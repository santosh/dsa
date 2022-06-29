package sort;

import java.util.Arrays;

/**
 * There are only two number in an array multiple times, 0s and 1s.
 * You have to move all the 0 to the left side and 1s to the right
 * side.
 */
public class MoveEvenToLeftOddToRight {
    public static void twoPointer(int[] arr)  {
        int i=0;
        int j=arr.length-1;

        while (i<j) {
            // i will represent 1
            while (arr[i] % 2 == 0) {
                i++;
            }

            // i will represent 1
            while (arr[j] % 2 != 0) {
                j--;
            }

            if (i < j) {
                // swap i and  j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 9, 5, 10, 7};
        twoPointer(arr);
        System.out.println(Arrays.toString(arr));
    }
}
