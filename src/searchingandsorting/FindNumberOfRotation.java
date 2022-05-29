package searchingandsorting;

/**
 * An array was once sorted. Since then it was rotated n number of
 * times. Find n.
 */
public class FindNumberOfRotation {
    public static int solution(int[] arr) {
        int min = arr[0];
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 1, 2, 3, 4};

        System.out.println(solution(arr));
    }
}
