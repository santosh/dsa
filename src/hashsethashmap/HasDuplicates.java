package hashsethashmap;

import java.util.HashMap;

public class HasDuplicates {
    public static boolean isDuplicate(int[] arr) {
        HashMap<Integer, Integer> store = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (store.containsKey(arr[i])) {
                return true;
            }
            else {
                store.put(arr[i], 0);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] arr = {2, 3, 4, 5, 6, 7};

        int[] arr = {3, 4, 3, 5, 7, 7, 9};
        boolean res = isDuplicate(arr);
        System.out.println(res);
    }
}
