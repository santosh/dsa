package array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Description
 * You are given an unsorted array of size n. Elements are in the range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in the array. Find these two numbers.
 *
 * Examples:
 * Input: arr[] = {3, 1, 3}
 * Output: Missing = 2, Repeating = 3
 * Explanation: In the array,
 *
 * 2 is missing and 3 occurs twice
 *
 * Input: arr[] = {4, 3, 6, 2, 1, 1}
 * Output: Missing = 5, Repeating = 1
 */


public class RepeatingAndMissingNumber {
    static void findRepeatingAndMissing(int[] arr, int size) {
        int[] aux = new int[size+1];

        for (int i = 0; i < arr.length; i++) {
            aux[arr[i]] = aux[arr[i]]+1;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(aux[i]);
        }
        
        for (int i = 1; i <= arr.length; i++) {
            if (aux[i] > 1) {
                System.out.printf("Repeating no is : [%d]\n", i);
            }
            if (aux[i] == 0) {
                System.out.printf("Missing number is : [%d]\n", i);
            }
        }
    }
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0; i<n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int[] arr1 = {4, 3, 6, 2, 1, 1};
        int[] arr1 = {3, 1, 3};
        int n = arr1.length;
        findRepeatingAndMissing(arr1,n);
    }
}