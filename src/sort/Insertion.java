package sort;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 6, 7, 4};
        System.out.println(Arrays.toString(arr));
        insertionSortRecursive(arr, 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            int j=i;

            while (j-1>=0 && arr[j-1]>v) {
                arr[j] = arr[j-1];
                j--;
            }

            arr[j] = v;
        }
    }

    private static void insertionSortRecursive(int[] arr, int i) {
        if(i>=arr.length){
            return;
        }

        int v = arr[i];
        int j=i;

        while (j-1>=0 && arr[j-1]>v) {
            arr[j] = arr[j-1];
            j--;
        }

        arr[j] = v;

        insertionSortRecursive(arr,i+1);
    }

    /**
     * Arrange array in: highest, lowest, 2nd highest, 2nd lowest,
     * 3rd highest, 3rd lowest and so on.
     * @param arr
     */
    private static int[] transform(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] nextArr = new int[arr.length];

        int i=0 , j = arr.length-1;
        int temp = 0;
        while(i<j){
            arr[temp++] =arr[i];
            arr[temp++] =arr[j];
            i++;
            j--;
        }

        return nextArr;
    }
}
