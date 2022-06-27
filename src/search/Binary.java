package search;

public class Binary {
    private static boolean search(int[] arr, int numToFind) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start+(end-start)/2;

            if (arr[mid] == numToFind) {
                return true;
            } else if (arr[mid] > numToFind) {
                end = mid-1;
            } else if (arr[mid] < numToFind) {
                start = mid+1;
            }
        }
        return false;
    }

    private static boolean searchRecursive(int[] arr, int numToFind, int start, int end) {
        if (start > end) {
            return false;
        }

        int mid = start+(end-start)/2;

        if (arr[mid] == numToFind) {
            return true;
        } else if (arr[mid] > numToFind) {
            return searchRecursive(arr, numToFind, start, mid-1);
        } else {
            return searchRecursive(arr, numToFind, mid+1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(searchRecursive(arr, 12, 0, arr.length-1));
    }
}
