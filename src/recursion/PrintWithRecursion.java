package recursion;

public class PrintWithRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        print(arr, 0);
        System.out.println();
        printRev(arr, 0);
    }

    /* There are always 3 parts of a recursive function:
     * 1. Base condiditon
     * 2. Logic
     * 3. Recursive call
     */
    private static void print(int[] arr, int startIndex) {
        // Base condition
        if (startIndex >= arr.length) {
            return;
        }
        // logic
        System.out.print(arr[startIndex] + " ");

        // recursive call
        print(arr, startIndex + 1);
    }

    /* You can change the direction of printing just by swapping the
     * position of logic and recursion call position.
     */
    private static void printRev(int[] arr, int startIndex) {
        // Base condition
        if (startIndex >= arr.length) {
            return;
        }

        // recursive call
        printRev(arr, startIndex + 1);

        // logic
        System.out.print(arr[startIndex] + " ");

    }
}
