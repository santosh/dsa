package array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Description:
 *
 * An array of numbers is given. It has all unique elements except one.
 * Find the only duplicate element in that array having all other unique elements.
 *
 * Return the single duplicate number which is present in the array
 *
 * First line of the input takes N (Number of elements).
 * Second line of the input takes N numbers.
 *
 * Input:
 * 10
 * 12 10 11 12 13 14 15 16 19 20
 *
 * Output:
 * 12
 *
 * Explanation:
 * 12 is the only number which is duplicate in the array.
 */

public class OnlyRepeatedNumber {
    public static int findRepeatedNumber(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return  -1;
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findRepeatedNumber(arr, n);

        System.out.println(result);
    }
}