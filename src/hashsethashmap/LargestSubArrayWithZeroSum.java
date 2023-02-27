package hashsethashmap;

import java.util.HashMap;
import java.util.Scanner;

public class LargestSubArrayWithZeroSum {
    public static int largestSubArrayWithZeroSum(int[] arr) {
        // store sum and index pointer
        HashMap<Integer, Integer> store = new HashMap<>();

        int sum = 0;
        int i = -1;
        int max = 0;

        store.put(sum, i);
        while (i < arr.length - 1) {
            i++;
            sum += arr[i];
            if (store.containsValue(sum)) {
                // if sum has appeared before, find the index and subtract from current index
                int len = i - store.get(sum);
                if (len > max) {
                    max = len;
                }
            } else {
                store.put(sum, i);
            }
        }

        return max;
    }
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int[] arr = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};
        int result = largestSubArrayWithZeroSum(arr);
        System.out.println(result);
    }
}