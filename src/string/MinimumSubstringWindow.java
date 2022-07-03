package string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Arrays;
// Class name should be "Source",
// otherwise solution won't be accepted
public class MinimumSubstringWindow {
    public static String minimumWindowSubstring(String str){
        int n = str.length();
        int distCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            if (map.containsKey(str.charAt(i)))
            {
                Integer a = map.get(str.charAt(i));
                map.put(str.charAt(i),a+1);
            }
            else
            {
                map.put(str.charAt(i), 1);
            }
        }
        distCount = map.size();
        int size = Integer.MAX_VALUE;
        String res = "";

        for (int i = 0; i < n; i++)
        {
            int count = 0;
            int visited[] = new int[256];
            for(int j = 0; j < 256; j++)
                visited[j] = 0;
            String subStr = "";
            for (int j = i; j < n; j++)
            {
                if (visited[str.charAt(j)] == 0)
                {
                    count++;
                    visited[str.charAt(j)] = 1;
                }
                subStr += str.charAt(j);
                if (count == distCount)
                    break;
            }
            if (subStr.length() < size && count == distCount)
            {
                res = subStr;
                size=res.length();
            }
        }
        return res;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(minimumWindowSubstring(str));
    }
}