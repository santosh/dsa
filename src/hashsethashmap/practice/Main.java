package hashsethashmap.practice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Hello");
        map.put(null, "World");
        map.put(null, null);
        System.out.print(map.size());
    }
}
