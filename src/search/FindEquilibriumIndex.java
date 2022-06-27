package array;

public class FindEquilibriumIndex {
    public int findEquilibriumIndex(int[] arr){
        int left  =0 ;
        int right = arr.length-1;
        int mid = left + (right-left)/2;

        /**
         * Find the left sum  0 to mid-1 index
         */
        int sumLeft = arr[0];
        for(int i=1;i<mid;i++){
            sumLeft = sumLeft+arr[i];
        }

        /**
         * Find the right sum mid+1 to last index
         */
        int sumRight = arr[mid+1];
        for(int i= mid+2;i<arr.length;i++){
            sumRight = sumRight + arr[i];
        }

        if(sumRight > sumLeft){
            /**
             * We need to take few elements from right and add few elements in left
             */
            while(sumRight>sumLeft && mid<arr.length-1){
                sumLeft = sumLeft+ arr[mid];
                sumRight = sumRight - arr[mid+1];
                mid = mid+1;
            }
        }else if(sumRight<sumLeft){
            /**
             * We need to take few elements from left and add to the elements in right
             */
            while(sumLeft>sumRight && mid>0){
                sumRight = sumRight +arr[mid];
                sumLeft = sumLeft - arr[mid-1];
                mid = mid-1;
            }
        }
        if(sumLeft == sumRight){
            return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
