package array;

/* Given an array of N integers and integer K. Task is to check whether the sum of three integers from array is equals to K.

Condition:
x < y < z
arr[x] < arr[y] < arr[z]
*/

public class TripletWithGivenSum {
    public static boolean isTriplet(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    if (arr[i] + arr[j] + arr[l] == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
