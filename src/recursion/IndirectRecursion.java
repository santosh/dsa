package recursion;

/**
 * Indirect recursion is when one function calls another function
 * which is not same as the called function whereas in direct
 * recursion, same function calls itself.
 */
public class IndirectRecursion {
    public static void main(String[] args) {
        // Print the first 10 integers using indirect recursion
        print1(1, 10);
    }

    /**
     * Indirect recursion
     *      - more than one function
     */
    public static void print1(int start, int max) {
        // base condition
        if (start > max) {
            return;
        }
        System.out.println(start);
        print2(start+1, max);
    }

    public static void print2(int start, int max) {
        // base condition
        if (start > max) {
            return;
        }
        System.out.println(start);
        print1(start+1, max);
    }
}
