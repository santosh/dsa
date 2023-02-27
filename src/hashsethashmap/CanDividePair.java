package hashsethashmap;

import java.util.Map;

/*
* Given an array of integers and a number k, write a function that returns true if
* the given array can be divided into pairs such that the sum of every pair is divisible by k.
* */
public class CanDividePair {
    public static boolean canDivideInPairs(int[] arr, int k) {
        if (arr.length % 2 == 1)
            return false;

        Map<Integer, Integer> map = new java.util.HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int rem = ((arr[i] % k) + k) % k;
            if (!map.containsKey(rem)) {
                map.put(rem, 0);
            }
            map.put(rem, map.get(rem) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            int rem = ((arr[i] % k) + k) % k;

            if (2 * rem == k) {
                if (map.get(rem) % 2 == 1)
                    return false;
            } else if (rem == 0) {
                if (map.get(rem) % 2 == 1)
                    return false;
            } else {
                if (map.get(k - rem) != map.get(rem))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
