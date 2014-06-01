package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderA {

    static Map<String, Map<String, Boolean>> map = new HashMap<String, Map<String, Boolean>>();

    /**
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
     * 1) Use two queues to do level-wise traversal
     * 2) Make sure boundary condition works
     *    e.g. If start can transform to end in one step, the length will be 2
     * 3) Since we are trying to find the shortest length, if a word has been expanded, we should not expand it again
     *    If we re-expand for the same word, it must be at the same level or deeper than the previous level
     *    Thus, we should delete any word that has been expanded from dict
     * 4) To avoid repeated search, use Map of Map to cache
     */
    public static int ladderLength(String start, String end, Set<String> dict) {
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
                Iterator<String> iter = dict.iterator();
                while (iter.hasNext()) {
                    String s = iter.next();
                    if (isTransformable(w, s)) {
                        queue2.add(s);
                        iter.remove();
                    }
                }
            }
            len += 1;

            while (!queue2.isEmpty()) {
                String w = queue2.remove(0);
                if (isTransformable(w, end)) {
                    return len + 1;
                }
                Iterator<String> iter = dict.iterator();
                while (iter.hasNext()) {
                    String s = iter.next();
                    if (isTransformable(w, s)) {
                        queue1.add(s);
                        iter.remove();
                    }
                }
            }
            len += 1;
        }

        return 0;
    }

    private static boolean isTransformable(String w, String s) {
        if (map.containsKey(w) && map.get(w).containsKey(s))
            return map.get(w).get(s);

        Map<String, Boolean> m = new HashMap<String, Boolean>();
        int count = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) != s.charAt(i)) {
                count += 1;
            }

            if (count > 1) {
                m.put(s, false);
                map.put(w, m);
                return false;
            }
        }

        if (count == 1) {
            m.put(s, true);
            map.put(w, m);;
            return true;
        } else {
            m.put(s, false);
            map.put(w, m);
            return false;
        }
    }
}
