package string;

import java.util.*;


public class PermutationOfAString {
    public static  void stringPermutations(String str, int left, int right) {
        // write your code here
        permute(str, left, right);
    }

    private static void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        if(len <= 3)
            stringPermutations(str,0,len-1);
        else
            System.out.print("NA");
    }
}
