package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Given an array of odd and even numbers. Sort odd in ascending order.
 * Then sort even in descending order.
 *Array
 * Example:
 * Input: 3 6 8 9 5 10 7
 * Output: 3 5 7 9 10 8 6
 */
public class SortEvenAndOdd {
    public static int[] sortEvenOdd(int[] arr) {
        ArrayList<Integer> oddElements = new ArrayList<Integer>();
        ArrayList<Integer> evenElements = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenElements.add(arr[i]);
            } else {
                oddElements.add(arr[i]);
            }
        }

        Collections.sort(oddElements);
        Collections.sort(evenElements, Collections.reverseOrder());

        for (Integer i : evenElements) {
            oddElements.add(i);
        }

        return oddElements.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String args[] ) throws Exception {
       int[] arr = {3, 6, 8, 9, 5, 10, 7};
       int[] result = sortEvenOdd(arr);

        System.out.println(Arrays.toString(result));
    }
}