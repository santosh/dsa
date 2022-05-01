package analysisofalgorithm;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BinarySearch {
    public static int search(int[] arr, int target){
        int left_index = 0; // set at start of the sorted array
        int right_index = arr.length - 1;  // set at the end of the sorted array

        while (left_index <= right_index) {
            int mid_index = left_index + (right_index - left_index) / 2;

            if (target == arr[mid_index]) {
                return mid_index;
            }

            if (target < arr[mid_index]) {
                right_index = mid_index - 1;
            } else {
                left_index = mid_index + 1;
            }


        }
        return -1;
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(search(arr, target));
    }
}