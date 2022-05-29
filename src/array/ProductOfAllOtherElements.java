package array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ProductOfAllOtherElements {
    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static int product(int[] arr, int leftProduct, int index){
        if (index >= arr.length) {
            return 1;
        }

        int currentData = arr[index];
        int productTillCurrent = arr[index]*leftProduct;
        int productRight = product(arr, productTillCurrent, index+1);
        arr[index] = leftProduct*productRight;
        return currentData*productRight;
    }

    public static int product2(int[] arr, int leftProduct, int index) {
        int prod = 1;

        for (int i = 0; i < arr.length; ++i) {
            prod *= arr[i];
        }

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = prod / arr[i];
        }
        return 0;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0; i<n; i++) {
//            arr[i] = sc.nextInt();
//        }
        int[] arr = {1, 2, 3, 4, 5};

        product(arr, 1,0);
        print(arr);
    }
}