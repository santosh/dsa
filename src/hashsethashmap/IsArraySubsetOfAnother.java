package hashsethashmap;

import java.util.*;

public class IsArraySubsetOfAnother {
    static boolean isSubset(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();

        for (int j : arr1) {
            set.add(j);

        }

        for (int j : arr2) {
            if (!set.contains(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};

        System.out.println(isSubset(arr1, arr2));
    }
}
