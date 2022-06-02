package searchingandsorting;

/**
 * There is an array with elements in increasing order, then after a certain
 * index, the elements start to appear in descending order.
 *
 * Find the highest element in O(logn).
 */
public class FindHighestElement {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 3, 2, 1};
        int[] arr = {1, 2, 3, 9, 8, 7, 6, 5, 4};
        System.out.println(findHighest(arr, 0, arr.length-1));
    }

    private static int findHighest(int[] arr, int start, int end) {
        // if there is 1 element return that
        if (start == end) {
            return arr[start];
        }

        // if there is 2 element
        if (start+1 == end) {
            return arr[start] > arr[end] ? arr[start] : arr[end];
        }

        int mid = start+(end-start)/2;

        if (arr[mid] > arr[mid] + 1 && arr[mid] > arr[mid-1]) {
            return arr[mid];
        }

        if (arr[mid] > arr[mid+1] && arr[mid] < arr[mid-1]) {
            return findHighest(arr, start,mid-1);
        } else {
            return findHighest(arr, mid+1, end);
        }
    }
}
