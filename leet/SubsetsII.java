package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII {

    public static void main(String[] args) {
        int[] num = new int[]{1, 1};
        List<List<Integer>> result = subsetsWithDup(num);
        for (List<Integer> i : result) {
            for (Integer j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        result.add(temp);
        Arrays.sort(S);
        subsets(result, temp, S, 0);
        return result;
    }

    /**
     * Key optimizations:
     * 1) Don't put a node in the frontier if it is already in the frontier
     *
     * Loop invariant:
     * After each iteration, all the subsets that start with temp will be expanded.
     */
    private static void subsets(List<List<Integer>> result, List<Integer> temp, int[] S, int pos) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = pos; i < S.length; i++) {
            if (set.contains(S[i])) {
                continue;
            }
            set.add(S[i]);

            List<Integer> t = new ArrayList<Integer>(temp);
            t.add(S[i]);
            result.add(t);

            subsets(result, t, S, i + 1);
        }
    }

}
