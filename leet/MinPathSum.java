package leet;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;

        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;

        if (n == 0) {
            return 0;
        }

        int[][] sums = new int[m][n];

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i + 1 != m && j + 1 != n) {
                    sums[i][j] = grid[i][j] + Math.min(sums[i+1][j], sums[i][j+1]);
                    continue;
                } else if (i + 1 == m && j + 1 != n) {
                    sums[i][j] = grid[i][j] + sums[i][j+1];
                } else if (i + 1 != m && j + 1 == n) {
                    sums[i][j] = grid[i][j] + sums[i+1][j];
                } else {
                    sums[i][j] = grid[i][j];
                }
            }
        }

        return sums[0][0];
    }
}
