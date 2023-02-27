package stack;

public class LargestReectAreaInHistogram {
    public static int largestRectangle(int[] arr) {
        int[] result = new int[arr.length];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                result[stack.pop()] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = arr.length;
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int area = (result[i] - i) * arr[i];
            max = Math.max(max, area);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestRectangle(arr));
    }
}
