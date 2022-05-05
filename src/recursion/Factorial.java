package recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(iterative(5));
        System.out.println(recursive(5));
    }

    private static int recursive(int n) {
        if (n == 1) {
            return 1;
        }

        return n * recursive(n-1);
    }

    private static int iterative(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
