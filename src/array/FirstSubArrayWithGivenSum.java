package array;

public class FirstSubArrayWithGivenSum {
    public static void findSubArray(int[] arr, int K) {
        int curr_sum = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= arr.length; i++) {
            // If curr_sum exceeds the K,
            // then remove the starting elements
            while (curr_sum > K && start < i - 1) {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum,
            // then return true
            if (curr_sum == K) {
                int p = i - 1;
                for (int j=start; j<p+1; j++) {
                    System.out.print(arr[j]+ " ");
                }

                break;
            }


            // Add this element to curr_sum
            if (i < arr.length)
                curr_sum = curr_sum + arr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {19, 1, 5, 8, 20, 4, 9};
        findSubArray(arr, 14);
    }
}
