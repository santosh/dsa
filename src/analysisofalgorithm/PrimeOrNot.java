package analysisofalgorithm;
/*
Given an array of N integers. Task is to find each integer is prime or not.

Note: Return an array of 1 and 0. If it's a prime number return 1 else return 0.

First line of the input takes N (Number of element in the array).
Second line of the input takes N integers.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class PrimeOrNot {
    public static boolean isPrime(int num) {
        boolean isPrime = true;

        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
    public static int[] checkPrime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] res = checkPrime(arr);

        for(int i=0; i<res.length; i++) {
            if(i == res.length - 1) {
                System.out.print(res[i]);
            } else {
                System.out.print(res[i] + " ");
            }
        }

    }
}