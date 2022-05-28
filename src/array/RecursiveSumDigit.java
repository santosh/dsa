package array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Description
 * Given a number, we need to find sum of its digits using recursion.
 *
 * Input : 12345
 * Output : 1+2+3+4+5 => 15 => 1+5 => 6
 *
 * Input : 45632
 * Output :4+5+6+3+2 => 20 => 2+0 => 2
 */
public class RecursiveSumDigit {
    static int recursiveSumDigits(int n) {
        if (n < 10) {
            return n;
        }

        return recursiveSumDigits(sumDigits(n));
    }

    private static int sumDigits(int n) {
        if (n==0) return 0;
        return (n%10 + sumDigits(n/10));
    }

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
        int n = 852;
        System.out.println(recursiveSumDigits(n));
    }
}