package recursion;

/**
 * Tail recursion is when recursive call is the last step in the
 * recursion function:
 *      Base condition
 *      Logic
 *  --> Recursive call
 */
public class TailAndNonTailRecursion {
    public static void main(String[] args) {

    }

    public static void tailPrintNum(int[] arr, int sI) {
        if (sI >= arr.length) {
            return;
        }
        System.out.println(arr[sI]);
        tailPrintNum(arr, sI+1);  // last step -- tail recursion
    }

    public static void nonTailPrintNum(int[] arr, int sI) {
        if (sI >= arr.length) {
            return;
        }
        nonTailPrintNum(arr, sI+1);  // not last step -- non-tail recursion
        System.out.println(arr[sI]);
    }
}
