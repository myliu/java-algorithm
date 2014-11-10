package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        result.add(temp);
        Arrays.sort(S);
        subsets(result, temp, S, 0);
        return result;
    }

    private void subsets(List<List<Integer>> result, List<Integer> temp, int[] S, int pos) {
        for (int i = pos; i < S.length; i++) {
            List<Integer> t = new ArrayList<Integer>(temp);
            t.add(S[i]);
            result.add(t);

            subsets(result, t, S, i + 1);
        }
    }

}
