package string;

public class ReverseAString {
    static void swap(char a[], int index1, int index2) {
        char temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    // A stack based function to reverse a string
    static String reverse(String str) {
        char[] charr = str.toCharArray();
        int n = charr.length, i;

        for (i = 0; i < n / 2; i++) {
            swap(charr, i, n - i - 1);
        }

        return String.valueOf(charr);
    }

    public static void main(String[] args) {
        String str = "Reverse me!";
        
        String reversed = reverse(str);
        System.out.println(reversed);
    }
}
