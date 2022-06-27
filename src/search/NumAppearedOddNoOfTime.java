package array;

/**
 * In an array, all the number have appeared even number of times.
 * Except one. There is 1 number which has appeared odd number of time.
 *
 * Find that number.
 */
public class NumAppearedOddNoOfTime {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 5, 6, 4, 2, 6, 5};

        System.out.println(findOddNumber(arr));
    }

    private static int findOddNumber(int[] arr) {
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result = result ^ arr[i];
        }

        return result;
    }
}
