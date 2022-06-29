package sort;

public class MedianOf2SortedArray {

    private static int median(int[] arr1, int[] arr2) {
        int[] combined = merge(arr1, arr2);

        int median = (combined.length - 1) / 2;

        return combined[median];
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];

        int arr1Index = 0;
        int arr2Index = 0;
        int combinedArrIndex = 0;

        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            if (arr1[arr1Index] <= arr2[arr2Index]) {
                combined[combinedArrIndex] = arr1[arr1Index];
                arr1Index++;
            } else {
                combined[combinedArrIndex] = arr2[arr2Index];
                arr2Index++;
            }
            combinedArrIndex++;
        }

        while (arr1Index < arr1.length) {
            combined[combinedArrIndex++] = arr1[arr1Index++];
        }

        while (arr2Index < arr2.length) {
            combined[combinedArrIndex++] = arr2[arr2Index++];
        }

        return combined;
    }

    public static void main(String[] args) {
//        int[] arr1 = {1, 2, 3};
//        int[] arr2 = {3, 4, 5, 6};

        int[] arr1 = {1, 2, 3, 4};

//        int[] arr1 = {0, 1, 2, 3, 4, 5, 6};
//        int[] arr2 = {3, 10, 15, 20, 23};

        int med = median(arr1, arr1);
        System.out.println(med);
    }
}