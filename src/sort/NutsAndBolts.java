package sort;

import java.util.Arrays;

/**
 * There are two arrays, nuts and bolts. There is 1:1 mapping of
 * each of the element in the array. Meaning that both array has the
 * same elements, but they don't have the same index.
 *
 * Given nuts array, arrange bolts to have the same index as nuts.
 */
public class NutsAndBolts {
    private static int swaps = 0;
    public static void matchNutsNBolts(char[] nuts, char[] bolts, int start,
                                       int end) {
        if (start < end) {
            int pivot = partition(nuts, start, end, bolts[end]);

            partition(bolts, start, end, nuts[pivot]);

            matchNutsNBolts(nuts, bolts, start, pivot - 1);
            matchNutsNBolts(nuts, bolts, pivot + 1, end);
        }
    }

    private static int partition(char[] arr, int start, int end, char pivot) {
        int i = start;
        char temp1, temp2;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                i++;
                swaps++;
            } else if (arr[j] == pivot) {
                temp1 = arr[j];
                arr[j] = arr[end];
                arr[end] = temp1;
                j--;
                swaps++;
            }
        }
        temp2 = arr[i];
        arr[i] = arr[end];
        arr[end] = temp2;

        return i;
    }

    public static void main(String[] args) {
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        matchNutsNBolts(nuts, bolts, 0, nuts.length - 1);

        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));

        System.out.println(swaps);
    }
}
