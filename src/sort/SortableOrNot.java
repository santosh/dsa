package sort;

/**
 * Given an array of integers, and another array of same length with boolean
 * indicating whether that index is sortable or not.
 *
 * Return whether the entire array is sortable.
 */
public class SortableOrNot {
    public static boolean canBeSorted(int[] arr, boolean[] b) {
        for (int i=arr.length-1; i>=9; i--) {
            for (int j=0; j<i;j++) {
                if (!b[j]) {
                    return false;
                } else {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
