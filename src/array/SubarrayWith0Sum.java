package array;

import java.util.Scanner;

public class SubarrayWith0Sum {

    public static boolean subArraySum(int arr[]) {
        int currentSum = arr[0], start = 0;

        // Pick a starting point
        for (int i = 1; i < arr.length; i++) {
            while (currentSum > 0 && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }

            if (currentSum == 0) {
                return true;
            }

            if (i < arr.length)
                currentSum = currentSum + arr[i];
        }
        return false;
    }
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0; i<n; i++) {
//            arr[i] = sc.nextInt();
//        }
        int[] arr1 = {3, 4, -5, 1, 6};
        System.out.println(subArraySum(arr1));
    }
}