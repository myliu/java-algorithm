package leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumber {

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 2, 1 };
        int a = singleNumberII(A);
        System.out.println(a);
    }

    public static int singleNumber(int[] A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int a : A) {
            int count = 0;
            if (map.containsKey(a))
                count = map.get(a);
            map.put(a, ++count);
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }

        return -1;
    }

    public static int singleNumberII(int[] A) {
        int result = 0;
        for (int i : A) {
            result ^= i;
        }
        return result;
    }

}
