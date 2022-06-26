package sort;

public class KthSmallestElement {
    public static int pivotIndex(int[] arr, int start, int end) {
        int pivotValue = arr[end];
        int pivotIndex = start-1;  // initial value of pivotValue index

        for (int i=start; i<end; i++) {
            if (arr[i] < pivotValue) {
                pivotIndex++;
                swap(arr, pivotIndex, i);
            }
        }
        pivotIndex++;
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    private static void swap(int[] arr, int p, int i) {
        int temp = arr[p];
        arr[p] = arr[i];
        arr[i] = temp;
    }

    public static int kthSmallestElement(int[] arr, int left, int right, int k) {
        if (k>0 && k<=right-left+1) {
            int pi = pivotIndex(arr, left, right);

            if (pi-left+1 == k) {
                return arr[pi];
            } else if (pi-left+1 > k) {
                return kthSmallestElement(arr, left, pi-1, k);
            } else {
                return kthSmallestElement(arr, pi+1, right, k);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 8, 3, 0, 2, 1, 4};
        System.out.println(kthSmallestElement(arr, 0, arr.length-1, 5));
    }
}
