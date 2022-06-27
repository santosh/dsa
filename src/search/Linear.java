package search;

public class Linear {
    public static boolean search(int[] arr, int numToFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == numToFind) {
                return true;
            }
        }
        return false;
    }

    public static boolean searchRec(int[] arr, int numToFind, int start) {
        if (start >= arr.length || start < 0) {
            return false;
        }

        return arr[start] == numToFind || searchRec(arr, numToFind, ++start);
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 7, 34, 2 ,8, 44, 3};

        System.out.println(searchRec(arr, 2, 0));
        System.out.println(searchRec(arr, 4, 0));
    }
}
