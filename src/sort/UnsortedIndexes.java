package sort;

/**
 * Given an nearly sorted array. You have to find subarray which is unsorted.
 */
public class UnsortedIndexes {
    public static void printUnsortedIndexes(int[] arr) {
        int start, end = arr.length - 1;


        for (start = 0; start < arr.length; start++) {
            if (arr[start] > arr[start + 1]) {
                break;
            }
        }

        if (start == arr.length - 1) {
            System.out.println("array already sorted");
        }

        for (end = arr.length-1; end>0; end--) {
            if (arr[end]<arr[end-1]) {
                break;
            }
        }

        // find mind and max value between start and end index
        int max = arr[start];
        int min = arr[start];

        for (int i = start; i <= end; i++) {
            if (arr[i]<min) min = arr[i];
            if (arr[i]>max) max = arr[i];
        }

        for(int i=0; i<start; i++) {
            if (arr[i]>min) {
                start=i;
                break;
            }
        }

        for (int i=arr.length-1;i>end;i--) {
            if (arr[i]<max) {
                end=i;
            }
        }

        System.out.println("Array should be sorted between indexes "+ start + " and "+end );
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        printUnsortedIndexes(arr);
    }
}
