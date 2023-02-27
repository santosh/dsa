package hashsethashmap;

import java.util.Hashtable;

public class StringSum {
    public static int stringSum(String str) {
        Hashtable<Character, Integer> storage = new Hashtable<>();

        for (int i=0; i<str.length(); i++) {
            if (storage.containsKey(str.charAt(i))) {
                storage.put(str.charAt(i), storage.get(str.charAt(i))+1);
            } else {
                storage.put(str.charAt(i), 0);
            }
        }

        int sum = 0;
        for (int element: storage.values()) {
            sum += element;
        }

        return sum;
    }


    public static void main(String[] args) {
//        String str = "ada";
        String str = "abcaab";
        int sum = stringSum(str);
        System.out.println(sum);
    }
}

// Note: This solution does not passes 100% of the test cases.