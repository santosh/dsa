package analysisofalgorithm;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindPeakElement {
    public static int findThePeak(int[] arr) {
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i-1] < arr[i] && arr[i+1] < arr[i]) return arr[i];
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

        System.out.println(findThePeak(arr));
    }
}