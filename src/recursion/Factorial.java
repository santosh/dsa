package recursion;

public class Factorial {
    public static void main(String[] args) {
        // System.out.println(iterative(5));
        System.out.println(tailRecursive(5, 1));
    }

    private static int nonTailRecursive(int n) {
        if (n == 1) {
            return 1;
        }

        return n * nonTailRecursive(n-1);
    }

    private static int tailRecursive(int n, int result) {
        if (n <= 0) {
            return result;
        }

        return tailRecursive(n-1, result*n);
    }

    private static int iterative(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
