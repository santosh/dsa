package array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximumNumberOf1s {
    public static int findRowWithMaximumOnes(int[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;
        int j, max_row_index = 0;
        j = columns - 1;

        for (int i = 0; i < rows; i++) {
            while (j >= 0 && arr[i][j] == 1) {
                j = j - 1;
                max_row_index = i;
            }
        }
        if (max_row_index == 0 && arr[0][columns - 1] == 0)
            return -1;
        return max_row_index;
    }
    public static void main(String[] args) {
        int m, n, i, j;
        Scanner sc=new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int arr[][] = new int[m][n];
        for (i = 0; i < m; i++)
            for (j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();


        System.out.println(findRowWithMaximumOnes(arr));

    }
}