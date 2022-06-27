package search;

// Important Question

/**
 * Given an array of length n, where all the element are between 1 and n.
 * Find the frequency of all the elements.
 *
 * 1 <= arr[i] <= n
 */
public class FrequencyOfEachElement {
    public static void findFrequency(int[] arr) {
        for (int j = 0; j < arr.length; j++)
            arr[j] = arr[j] - 1;

        for (int i = 0; i < arr.length; i++)
            arr[arr[i] % arr.length] = arr[arr[i] % arr.length] + arr.length;

        for (int i = 0; i < arr.length; i++)
            System.out.println(i + 1 + " : " + arr[i] / arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 4, 5};
        findFrequency(arr);
    }
}
