package leet;

import java.util.ArrayList;

public class PascalTriangle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (numRows == 0)
            return result;

        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        result.add(firstRow);

        if (numRows == 1)
            return result;

        ArrayList<Integer> secondRow = new ArrayList<Integer>();
        secondRow.add(1);
        secondRow.add(1);
        result.add(secondRow);

        if (numRows == 2)
            return result;

        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> p = result.get(i - 1);
            ArrayList<Integer> c = new ArrayList<Integer>();
            c.add(1);
            for (int j = 0; j < p.size() - 1; j++) {
                int k = p.get(j) + p.get(j + 1);
                c.add(k);
            }
            c.add(1);
            result.add(c);
        }

        return result;
    }
}
