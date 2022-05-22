package array;

import java.util.*;

/**
 * Description:
 *
 * Suppose that you have an array of length ‘n’ and a variable ‘k’. Write a program that will
 * take the array of length n and the variable k as inputs and will print a new array formed
 * by combining the elements of the given array such that each element of the new array is “k”
 * variable long.
 *
 * Input Format:
 *
 * First line represents the value of variable k.
 * The next line represents the length of the array (i.e. n)
 * Next consecutive n lines contain the elements of the array.
 * Output Format:
 *
 * Print the new array.
 */
public class PrintTheArray{

    public static void merge(int[] arr,int start, int end, int [] arr1, int k){
        //write your code here
        int resultantArrayIndex = 0;

        for (int i = 0; i < arr.length - 1; i+=k) {
            start = i;
            end = (i+k)-1;
            arr1[resultantArrayIndex] = aux(arr, start, end);
            resultantArrayIndex++;
        }
    }

    public static int aux(int[] subArr, int start, int end) {
        int finalNum = 0;
        for (int i = start; i <= end; i++) {
            finalNum = finalNum * 10 + subArr[i];
        }
        System.out.println(finalNum);

        return finalNum;
    }

    public static void main(String[] args) {
        int k,n;
//        Scanner s = new Scanner(System.in);
//        k = s.nextInt();
//        n = s.nextInt();
        int[] arr = {1, 6, 4, 7, 1, 9, 9, 4, 1, 4, 2, 2};
        k = 2;
//        for(int i = 0; i < n; i++){
//            arr[i] = s.nextInt();
//        }
        //write your code here
        int[] arr1 = new int[(arr.length)/k];
        merge(arr, arr[0], arr[arr.length-1], arr1, k);
    }
}