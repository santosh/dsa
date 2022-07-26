package hashsethashmap;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Given an array of sentences, your task is to count the number of words you have
 * encountered while traversing the sentences.
 */

public class CountWords {
    public static String[] countWords(String[] arr) {
        //Write your code here
        HashMap<String, Integer> wordCount = new HashMap<>();
        String[] resultantArray = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            String[] words = arr[i].split(" ");
            int[] resultantSubArray = new int[words.length];

            for (int j = 0; j < words.length; j++) {
                if (wordCount.containsKey(words[j])) {
                    wordCount.put(words[j], wordCount.get(words[j])+1);
                } else {
                    wordCount.put(words[j], 1);
                }
                resultantSubArray[j] = wordCount.get(words[j]);
            }
            resultantArray[i] = Arrays.toString(resultantSubArray);
        }

        return resultantArray;
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextLine();
        }
        System.out.println(Arrays.toString(countWords(arr)));
    }
}