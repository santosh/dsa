package array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Description
 * Given an array of size N, write a program to generate and print all the permutations of the given array.
 *
 * Examples:
 *
 * Input: arr[] = {1, 2}
 * Output:
 * 1 2
 * 2 1
 *
 * Input: {1, 2, 3}
 * Output:
 * 1 2 3
 * 2 1 3
 * 1 3 2
 * 3 1 2
 * 2 3 1
 * 3 2 1
 */
public class PermutationsOfAnArray {
    private static void print(int[] arr) {
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
    public static void arrayPermutations(int[] arr, int size) {
        if (size == 1)
            print(arr);

        for (int i = 0; i < size; i++) {
            arrayPermutations(arr, size - 1);
            int temp;
            if (size % 2 == 1) {
                temp = arr[0];
                arr[0] = arr[size - 1];
            } else {
                temp = arr[i];
                arr[i] = arr[size - 1];
            }
            arr[size - 1] = temp;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        arrayPermutations(arr, arr.length);
    }
}