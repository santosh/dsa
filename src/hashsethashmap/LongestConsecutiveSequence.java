package hashsethashmap;
import java.util.*;
public class LongestConsecutiveSequence {
    public static int longestSubsequence(int[] arr) {
        //Write the code here
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < arr.length; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < arr.length; ++i)
        {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i] - 1))
            {
                // Then check for next elements
                // in the sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this
                // length is more
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 15, 6, 11, 43, 14, 13, 12, 18, 22};
        int result = longestSubsequence(arr);
        System.out.println(result);
    }
}
