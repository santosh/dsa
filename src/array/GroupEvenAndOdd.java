package array;

import java.util.Arrays;

/**
 * Given an array of integers, arrange them in such a way that all the
 * odd are on the right side of array and all the even to the left side.
 *
 * Use no extra space.
 */
public class GroupEvenAndOdd {
    private static void arrange2(int[] arr) {
        int left = 0;  // even
        int right = arr.length-1; // odd

        while (left < right) {
            // move left to the right till I find even numbers
            while (arr[left] % 2 == 0) {
                left++;
            }

            // move right to the left till I find odd numbers
            while (arr[right] % 2 != 1) {
                right--;
            }

            // swap left and right
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    private static void arrange(int[] arr) {
        int oddIndex =0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==0) {
                int t = arr[i];
                arr[i] = arr[oddIndex];
                arr[oddIndex] = t;
                oddIndex++;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] arr = {17, 25, 32, 44, 75, 66, 87, 82, 91, 15};
        int[] arr = {0, 2};


        arrange(arr);

        System.out.println(Arrays.toString(arr));
    }
}
