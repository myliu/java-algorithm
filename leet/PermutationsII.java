package leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PermutationsII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] num = new int[]{3,3,0,0,2,3,2};
        List<List<Integer>> result = permuteUnique(num);
        for (List<Integer> i : result) {
            for (Integer j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> remaining = new ArrayList<Integer>();
        for (int i : num) {
            remaining.add(i);
        }
        permute(result, temp, remaining);
        return result;
    }

    /**
     * Key optimizations:
     * 1) Perform de-duplication when expand each node
     *    If the child is a duplicate, don't add it to the frontier
     */
    private static void permute(List<List<Integer>> result, List<Integer> temp, List<Integer> remaining) {
        if (remaining.isEmpty()) {
            result.add(temp);
            return;
        }

        Set<Integer> dedup = new HashSet<Integer>();
        Iterator<Integer> iter = remaining.iterator();
        while (iter.hasNext()) {
            Integer i = iter.next();

            if (dedup.contains(i)) {
                continue;
            }
            dedup.add(i);

            List<Integer> t = new ArrayList<Integer>(temp);
            List<Integer> r = new ArrayList<Integer>(remaining);
            t.add(i);
            r.remove(i);
            permute(result, t, r);
        }
    }
}
