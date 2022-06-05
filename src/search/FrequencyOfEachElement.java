package search;

import java.util.Arrays;

// Important Question

/**
 * Given an array of length n, where all the element are between 1 and n.
 * Find the frequency of all the elements.
 *
 * 1 <= arr[i] <= n
 */
public class FrequencyOfEachElement {
    public static void findFrequency(int[] arr) {
        // Bring all the elements in the range of [0, arr.length -1]

        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]-1;
        }

        // Transformation of the array
        for(int i=0;i<arr.length;i++){
            arr[arr[i]%arr.length] = arr[arr[i]%arr.length]+arr.length;
        }

        // Find the frequency
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]/arr.length;
        }

        System.out.println(Arrays.toString(arr));
        for (int i=0 ;i<arr.length;i++){
            System.out.println((i+1) +" -> "+arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 4, 5};
        findFrequency(arr);
    }
}
