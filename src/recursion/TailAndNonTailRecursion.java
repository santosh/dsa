package recursion;

/**
 * Tail recursion is when recursive call is the last step in the
 * recursion function:
 *      Base condition
 *      Logic
 *  --> Recursive call
 *
 *
 *  Significance of tail recursion:
 *  1. Tail recursive call is more space optimized.
 *
 *  The reason non-tail recursive function takes more memory because
 *  function has to maintain the state (variable values) until
 *  execution returns.
 */
public class TailAndNonTailRecursion {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        tailPrintNum(arr, 0);
        nonTailPrintNum(arr, 0);
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
