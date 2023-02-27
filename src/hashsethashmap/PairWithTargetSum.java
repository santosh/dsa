package hashsethashmap;

import java.util.*;

public class PairWithTargetSum {
    public static void pairWithSumK(int[] arr, int sum) {
        //Write your code here
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            int temp = sum - arr[i];
            if (s.contains(temp)) {
                System.out.println(arr[i] + " , "+temp);
            }
            s.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 4, 9};

        pairWithSumK(arr, 5);
    }
}
