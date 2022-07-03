package string;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CheckPalindrome {
    public static boolean checkpalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        char[] charr = s.toCharArray();
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[] ) throws Exception {
        String str = "was it a car or a cat i saw?";
        boolean result = checkpalindrome(str);
        System.out.println(result);
    }
}