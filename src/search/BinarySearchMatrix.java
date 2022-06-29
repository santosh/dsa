package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchMatrix {
    public static int[] searchInMatrix(int[][] arr, int target) {
        //Write your code here
        return findRow(arr, arr.length, arr[0].length, target);
    }

    static int[] findRow(int[][] a, int n, int m, int k) {
        int l = 0, r = n - 1, mid;

        int[] position = {-1, -1};

        while (l <= r) {
            mid = (l + r) / 2;

            // we'll check the left and
            // right most elements
            // of the row here itself
            // for efficiency
            if (k == a[mid][0]) // checking leftmost element
            {
                position[0] = mid;
                position[1] = 0;

                return position;
            }

            if (k == a[mid][m - 1]) // checking rightmost
            // element
            {
                int t = m - 1;

                position[0] = mid;
                position[1] = t;

                return position;
            }

            if (k > a[mid][0]
                    && k < a[mid]
                    [m - 1]) // this means the element
            // must be within this row
            {

                // search on this row
                return binarySearch(a, n, m, k,
                        mid); // we'll apply binary;
            }

            if (k < a[mid][0])
                r = mid - 1;
            if (k > a[mid][m - 1])
                l = mid + 1;
        }
        return position;
    }

    static int[] binarySearch(int[][] a, int n, int m, int k,
                             int x) // x is the row number
    {
        // now we simply have to apply binary search as we
        // did in a 1-D array, for the elements in row
        // number
        // x

        int[] position = {-1, -1};
        int l = 0, r = m - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;

            if (a[x][mid] == k) {
                position[0] = x;
                position[1] = mid;
                return position;
            }

            if (a[x][mid] > k)
                r = mid - 1;
            if (a[x][mid] < k)
                l = mid + 1;
        }
        return position;
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        int[] result = searchInMatrix(arr, target);
        System.out.println(Arrays.toString(result));
    }
}

