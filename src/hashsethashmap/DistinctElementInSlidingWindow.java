package hashsethashmap;

import java.util.*;

public class DistinctElementInSlidingWindow {
    public static ArrayList<Integer> countDistintInSlidingWindow(int[] arr, int k) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        ArrayList<Integer> res = new ArrayList<Integer>();

        // Traverse the first window and store count
        // of every element in hash map
        for (int i = 0; i < k; i++)
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);

        // Print count of first window
//        System.out.println(hM.size());

        // Traverse through the remaining array
        for (int i = k; i < arr.length; i++) {

            // Remove first element of previous window
            // If there was only one occurrence
            if (hM.get(arr[i - k]) == 1) {
                hM.remove(arr[i - k]);
            }

            else // reduce count of the removed element
                hM.put(arr[i - k],  hM.get(arr[i - k]) - 1);

            // Add new element of current window
            // If this element appears first time,
            // set its count as 1,
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);

            // Print count of current window
            res.add(hM.size());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        ArrayList<Integer> arraylist = countDistintInSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(arraylist.toArray()));
    }
}
