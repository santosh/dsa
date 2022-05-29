package array;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * We have been given a chessboard of size N*N. Now we need to place N queens on this chessboard such that no two queens attack each other.
 * For example, the following is the output matrix for above 4 queen problem ( i.e size of the chess board is 4*4)
 *
 *               { 0,  1,  0,  0}
 *               { 0,  0,  0,  1}
 *               { 1,  0,  0,  0}
 *               { 0,  0,  1,  0}
 */
public class NQueen {
    private static void printArr(int[][] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(" " + arr[i][j]
                        + " ");
            System.out.println();
        }
    }

    private static boolean isSafePosition(int[][] arr, int row, int col)
    {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (arr[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (arr[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < arr.length; i++, j--)
            if (arr[i][j] == 1)
                return false;

        return true;
    }

    private static boolean nQueenUtil(int[][] arr, int col)
    {
        if (col >= arr[0].length)
            return true;

        for (int i = 0; i < arr.length; i++) {
            if (isSafePosition(arr, i, col)) {
                arr[i][col] = 1;

                if (nQueenUtil(arr, col + 1) == true)
                    return true;

                arr[i][col] = 0;
            }
        }

        return false;
    }
    public static boolean nQueen()
    {
        int chessBoard[][] = { { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 } };

        if (!nQueenUtil(chessBoard, 0)) {
            System.out.print("Solution does not exist");
            return false;
        }

        printArr(chessBoard);
        return true;
    }
    public static void main(String[] args) {
        nQueen();
    }
}