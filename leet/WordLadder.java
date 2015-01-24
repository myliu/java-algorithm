package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    /**
     * Accepted
     * @param args
     */
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));

        int result = ladderLength(start, end, dict);
        System.out.println(result);
    }

    /**
     * Key optimizations:
     * 1) Two queues to perform level-wise traversal
     * 2) O(m*n)
     *    m: The number of combination of each word. e.g., hit is 26*3, and good is 26*4.
     *    n: The number of words in the dict
     *    O(n*n) is not acceptable
     * 3) Try to avoid traverse dictionary if possible because dict is large, and it is best used as HashTable
     * 4) This quest asks for the shortest path, so each word only needs to be expanded once
     * 5) Use StringBuilder for String manipulation
     * 6) Use char instead of String is possible
     */
    public static int ladderLength(String start, String end, Set<String> dict) {
        // Two queues to perform level-wise traversal
        List<String> queue1 = new ArrayList<String>();
        List<String> queue2 = new ArrayList<String>();
        int len = 1;
        queue1.add(start);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                String w = queue1.remove(0);
                if (isTransformable(w, end)) {
                    return len + 1;
                }
                Set<String> comb = combinator(w);
                for (String s : comb) {
                    if (dict.contains(s)) {
                        queue2.add(s);
                        dict.remove(s);
                    }
                }
            }
            len += 1;

            while (!queue2.isEmpty()) {
                String w = queue2.remove(0);
                if (isTransformable(w, end)) {
                    return len + 1;
                }
                Set<String> comb = combinator(w);
                for (String s : comb) {
                    if (dict.contains(s)) {
                        queue1.add(s);
                        dict.remove(s);
                    }
                }
            }
            len += 1;
        }

        return 0;
    }

    // O(m*n)
    // m: The number of combination of each word. e.g., hit is 26*3, and good is 26*4.
    // n: The number of words in the dict
    private static Set<String> combinator(String w) {
        Set<String> comb = new HashSet<String>();
        for (int i = 0; i < w.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char c = (char)('a' + j);
                StringBuilder sb = new StringBuilder(w);
                sb.setCharAt(i, c);
                comb.add(sb.toString());
            }
        }
        comb.remove(w);
        return comb;
    }

    private static boolean isTransformable(String w, String s) {
        int count = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) != s.charAt(i)) {
                count += 1;
            }

            if (count > 1) {
                return false;
            }
        }

        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}
