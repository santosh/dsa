package string;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length(); ++i)
            for (int j = 0; j < str2.length(); ++j)
                if (str1.charAt(i) == str2.charAt(j)) dp[i + 1][j + 1] = 1 + dp[i][j];
                else dp[i + 1][j + 1] =  Math.max(dp[i][j + 1], dp[i + 1][j]);
        return dp[str1.length()][str2.length()];
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int result = longestCommonSubsequence(str1, str2);
        System.out.println(result);
    }
}