package sort;

public class Merge {

    /**
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void sort(int[] arr, int start, int end) {
        // Base case
        if (start >= end) {
            return;
        }

        int mid = start + (end - start)/2;

        // divide in half
        sort(arr, start, mid);
        sort(arr, mid+1, end);

        merge(arr, start, mid, end);
    }

    /**
     * Array is sorted between start and mid,
     * array is also sorted between mid and end.
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[arr.length];
        int tIndex = start;

        int leftS = start;
        int rightS = mid+1;

        while (leftS <= mid && rightS <= end) {
            if (arr[leftS] < arr[rightS]) {
                temp[tIndex] = arr[leftS];
                leftS++;
            } else {
                temp[tIndex] = arr[rightS];
                rightS++;
            }
            tIndex++;
        }
        // If the elements in the left part is still left
        while (leftS <= mid) {
            temp[tIndex++] = arr[leftS++];
        }
        // if the element in the right part is still available
        while (rightS <= end) {
            temp[tIndex++] = arr[rightS++];
        }

        // copy the sorted temp array to original array
        for (int i=start; i<=end; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {

    }
}
