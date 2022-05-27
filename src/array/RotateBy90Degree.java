package array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RotateBy90Degree {
    static void rotate90Clockwise(int[][] arr) {
        // transpose of the matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // reverse rows
        for (int i = 0; i < arr.length; i++) {
            int li = 0;
            int ri = arr[i].length - 1;

            while (li < ri) {
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;

                li++;
                ri--;
            }
        }
    }

    static void rotate90CounterClockwise(int[][] arr) {
        // transpose of the matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    static void printArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
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


        rotate90CounterClockwise(arr);
        printArr(arr);

    }
}

//3 3
//1 2 3
//4 5 6
//7 8 9