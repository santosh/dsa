package string;

import java.util.Scanner;
import java.util.*;

public class CompareForUniqueCharacters {
    static String removeChars(String str, String secStr) {
        // write your code here
        for (int i = 0; i < secStr.length(); i++) {
            str = str.replace(String.valueOf(secStr.charAt(i)), "");
        }
        return str;
    }
    public static void main(String args[]){
        String str1 = "Upgrade";
        String str2 = "upGrad";
        str1 = str1.toLowerCase();
        str2=str2.toLowerCase();
        int length1 = str1.length();
        int length2 = str2.length();
        if (str1.equals(str2))
            System.out.print("same");
        if (length1 >= length2)
            System.out.println(removeChars(str1,str2));
        else
            System.out.print("NA");
    }
}