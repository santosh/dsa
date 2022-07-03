package string;

import java.util.*;

class CharacterRepeatingFirst {
    public static int findFirstRepeatedChar(String string) {
        //write your code here
        char[] str = string.toCharArray();

        HashSet<Character> h = new HashSet<>();

        for (int i = 0; i < str.length; i++) {
            if (h.contains(str[i]))
                return i;

            else // Else add element to hash set
                h.add(str[i]);
        }

        return -1;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int index = findFirstRepeatedChar(str);
        if(index != -1){
            System.out.println(str.charAt(index));
        }else{
            System.out.println("NA");
        }
    }
}