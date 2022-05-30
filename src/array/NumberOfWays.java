package array;

/**
 * Find number of ways a naturnal number can be written as unique sum
 * of natural numbers.
 */
public class NumberOfWays {
    public static void main(String[] args) {
        System.out.println(numOfWays(5, 1));
        System.out.println(numOfWays(3, 1));
        System.out.println(numOfWays(4, 1));
        System.out.println(numOfWays(7, 1));
    }

    private static int numOfWays(int target, int num) {
        if (target == num) {
            return 1;
        }

        if (num > target) {
            return 0;
        }

        return numOfWays(target-num, num+1) +
                numOfWays(target, num+1);
    }
}
