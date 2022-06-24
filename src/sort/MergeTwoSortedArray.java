package sort;

import java.util.Arrays;

/**
 * There are 2 arrays. array1 and array2. array1 already has capacity to
 * accommodate array2.
 *
 * Constraint: No extra space should be used.
 */
public class MergeTwoSortedArray {
    public static void merge(int[] big, int m, int[] small, int n) {
        int i = m-1;  // track element from right big array
        int j = n-1;  // track element from right small array
        int temp = m+n-1;  // track element from right last big array

        while (i>=0 && j>=0) {
            if (big[i]>small[j]) {
                big[temp] = big[i];
                i--;
            } else {
                big[temp] = small[j];
                j--;
            }
            temp--;
        }

        while (i>=0) {
            big[temp] = big[i];
            i--;
            temp--;
        }

        while (j>=0) {
            big[temp] = small[j];
            j--;
            temp--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[5];
        arr1[0] = 2;
        arr1[1] = 4;
        arr1[2] = 6;

        int[] arr2 = {1, 3};

        System.out.println(Arrays.toString(arr1));

        merge(arr1, 3, arr2, 2);

        System.out.println(Arrays.toString(arr1));
    }
}
