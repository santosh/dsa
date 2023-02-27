package pqueue;

public class RainTrappingProblem {
    // a function to return the number of unit squares where water is trapped
    static int findWater(int arr[], int n) {
        // initialize the output
        int result = 0;

        // maximum heighten elements/blocks/buildings on left and right
        int left_max = 0;
        int right_max = 0;

        // indices to traverse the array
        int lo =0, hi=n-1;
        while (lo <= hi) {
            if (arr[0] < arr[hi]) {
                if (arr[lo] > left_max) left_max = arr[lo]; // update left_max
                else result += left_max - arr[lo]; // water on current element
                lo++;
            } else {
                if (arr[hi] > right_max) right_max = arr[hi]; // update right_max
                else result += right_max - arr[hi]; // water on current element
                hi--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 0, 1, 3, 2};
        int n = arr.length;
        System.out.println(findWater(arr, n));
    }
}
