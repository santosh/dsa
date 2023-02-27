package hashsethashmap;

import java.util.HashMap;
import java.util.Map;

/* Given an array, find element a, b, c, d such that a+b = c+d. */
public class PairWithEqualSum {
    private static class Pair {
        private int first;
        private int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static boolean findPairs(int[] arr) {
        Map<Integer, Pair> map = new HashMap<Integer, Pair>();
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum))
                    map.put(sum, new Pair(i, j));

                else {
                    Pair p = map.get(sum);

                    System.out.println("(" + arr[p.first] + ", " + arr[p.second] +
                            ") and (" + arr[i] + ", " + arr[j] + ")");
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 1, 2, 9, 8};
        findPairs(arr);
    }
}
