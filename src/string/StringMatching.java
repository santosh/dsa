package string;

public class StringMatching {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "jsabcod";
//        System.out.println(findSubstring(s1, s2));

        String toSearchFor = "abc"; // Pattern String P
        String toSearchIn = "jrstdabcod"; // text String T
//        kmp(toSearchFor, toSearchIn);
        System.out.println(rabinKarp(toSearchFor, toSearchIn, toSearchIn.length()));

    }

    static int findSubstring(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();

        for (int i = 0; i < length2 - length1; i++) {
            int j;
            for (j = 0; j < length1; j++) {
                if (s2.charAt(i + j) != s1.charAt(j)) break;
            }

            if (j == length1) return i;
        }

        return -1;
    }

    public final static int d = 26;

    static void kmp(String pat, String txt)
    {

        int M = pat.length();
        int N = txt.length();

        int[] lps = new int[M];
        int j = 0;

        computeLPS(pat, M, lps);

        int i = 0;
        while ((N - i) >= (M - j))
        {
            if(pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if(j == M)
            {
                System.out.println("pattern occurs at index: " + (i - j));
                j = lps[j - 1];
            }

            else if(i < N && pat.charAt(j) != txt.charAt(i))
            {
                if (j != 0)
                    j = lps[j-1];
                else
                    i = i + 1;
            }
        }
    }

    static void computeLPS(String pat, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M)
        {
            if(pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else
            if(len !=0)
            {
                len = lps[len - 1];
            }
            else
            {
                lps[i] = len;
                i++;
            }
        }
    }


    static int rabinKarp(String to_search_for, String to_search_in, int length) {
        int m = to_search_for.length();
        int n = to_search_in.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        for (i = 0; i < m - 1; i++)
            h = (h * d) % length;


        for (i = 0; i < m; i++) {
            p = (d * p + to_search_for.charAt(i)) % length;
            t = (d * t + to_search_in.charAt(i)) % length;
        }

        for (i = 0; i <= n - m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (to_search_in.charAt(i + j) != to_search_for.charAt(j))
                        break;
                }

                if (j == m)
                    return i;
            }

            if (i < n - m) {
                t = (d * (t - to_search_in.charAt(i) * h) + to_search_in.charAt(i + m)) % length;
                if (t < 0)
                    t = (t + length);
            }
        }

        return -1;
    }
}