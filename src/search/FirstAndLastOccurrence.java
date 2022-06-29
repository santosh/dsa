package search;

/**
 * Given a sorted array, in which one element is repeating. Find
 * the first and the last occurrence of the repeating element.
 */
public class FirstAndLastOccurrence {
    public static int first(int arr[], int start, int end, int elemToFind) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || elemToFind > arr[mid - 1]) && arr[mid] == elemToFind)
                return mid;
            else if (elemToFind > arr[mid])
                return first(arr, (mid + 1), end, elemToFind);
            else
                return first(arr, start, (mid - 1), elemToFind);
        }
        return -1;
    }

    public static int last(int arr[], int start, int end, int x) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if ((mid == arr.length - 1 || x < arr[mid + 1]) && arr[mid] == x)
                return mid;
            else if (x < arr[mid])
                return last(arr, start, (mid - 1), x);
            else
                return last(arr, (mid + 1), end, x);
        }
        return -1;
    }

    public static void firstLastOccurrence(int[] arr, int x) {
        int firstIndex = first(arr, 0, arr.length - 1, x);
        int lastIndex = last(arr, 0, arr.length - 1, x);
        System.out.printf("%d %d", firstIndex, lastIndex);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 4, 4, 6, 7, 8, 9};
        int x = 4;
        firstLastOccurrence(arr, x);
    }
}
