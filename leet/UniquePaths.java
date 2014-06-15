package leet;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] array = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                array[i][j] = -1;
            }
        }
        return uniquePaths(m, n, array);
    }

    public int uniquePaths(int m, int n, int[][] array) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        if (m == 1) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        if (array[m][n] != -1) {
            return array[m][n];
        }

        int result = uniquePaths(m-1, n, array) + uniquePaths(m, n-1, array);
        array[m][n] = result;
        return result;
    }
}
