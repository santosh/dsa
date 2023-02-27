package array;

public class CountOfSmallerThanCurrentIndex {
    public static int[] getCounts(int[] arr) {
        int[] counts = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
            counts[i] = count;
        }
        return counts;
    }
}
