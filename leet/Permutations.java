package leet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Permutations {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3};
        List<List<Integer>> result = permute(num);
        for (List<Integer> i : result) {
            for (Integer j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> remaining = new ArrayList<Integer>();
        for (int i : num) {
            remaining.add(i);
        }
        permute(result, temp, remaining);
        return result;
    }

    private static void permute(List<List<Integer>> result, List<Integer> temp, List<Integer> remaining) {
        if (remaining.isEmpty()) {
            result.add(temp);
            return;
        }

        Iterator<Integer> iter = remaining.iterator();
        while (iter.hasNext()) {
            Integer i = iter.next();
            List<Integer> t = new ArrayList<Integer>(temp);
            List<Integer> r = new ArrayList<Integer>(remaining);
            t.add(i);
            r.remove(i);
            permute(result, t, r);
        }
    }
}
