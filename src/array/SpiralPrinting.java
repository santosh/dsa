package array;

import java.util.ArrayList;
import java.util.Scanner;

public class SpiralPrinting {
    public static int[] spiralPrint(int[][] arr) {
        ArrayList<Integer> finalArrayList = new ArrayList();

        int startRow = 0;
        int endRow = arr.length - 1;

        int startColumn = 0;
        int endColumn = arr[0].length - 1;

        while (startRow <= endRow && startColumn <= endColumn) {
            // print the first row
            for (int i = startColumn; i <= endColumn; i++) {
                finalArrayList.add(arr[startRow][i]);
            }
            startRow++;  // all the elements are printed so increment for next iteration

            // print end column
            for (int i = startRow; i <=endRow; i++) {
                finalArrayList.add(arr[i][endColumn]);
            }
            endColumn--;

            // Print the last row
            for (int i = endColumn; i >= startColumn; i--) {
                finalArrayList.add(arr[endRow][i]);
            }
            endRow--;

            // Print the first column
            for (int i = endRow; i >= startRow; i--) {
                finalArrayList.add(arr[i][startColumn]);
            }
            startColumn++;
        }

        int[] finalArray = finalArrayList.stream().mapToInt(i -> i).toArray();
        return finalArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int[] result = spiralPrint(arr);
        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
