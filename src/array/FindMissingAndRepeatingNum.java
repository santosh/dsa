package array;

/**
 * Given an array, with element appearing from 1 to n. There is one
 * number which does not exist. And there is one number which repeat.
 *
 * Find the missing number.
 * Find the repeating number.
 */
public class FindMissingAndRepeatingNum {
    public static void main(String[] args) {
        int[] arr  = {1, 2, 4, 5, 2, 6, 7, 8};
        findMissingAndRepeating(arr);
    }

    private static void findMissingAndRepeating(int[] arr) {
        int[] temp = new int[arr.length+1];

        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]] = temp[arr[i]] + 1;
        }

        for (int i = 1; i < arr.length; i++) {
            if (temp[i] == 0) {
                System.out.println(i + " is the missing num");
            }
            if (temp[i] == 2) {
                System.out.println(i + " is the repeating num");
            }
        }
    }
}
