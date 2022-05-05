package recursion;

public class PrintWithRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        print(arr, 0);
    }

    private static void print(int[] arr, int startIndex) {
        // Base condition
        if (startIndex >= arr.length) {
            return;
        }
        // logic
        System.out.print(arr[startIndex] + " ");
        startIndex++;

        // recursive call
        print(arr, startIndex);
    }
}
