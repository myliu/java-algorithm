package leet;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int col = searchColumn(matrix, target, 0, matrix.length-1);
        if (col == -1) {
            return false;
        } else if (col == -2) {
            return true;
        } else {
            return searchRow(matrix[col], target, 0, matrix[col].length-1);
        }
    }

    // Return -2 to indicate found target
    // Return -1 to indicate target not exist
    private int searchColumn(int[][] matrix, int target, int start, int end) {
        // Only one row left
        if (start >= end) {
            if (target == matrix[start][0]) {
                return -2;
            } else if (target < matrix[start][0]) {
                return -1;
            } else {
                // start is always valid, but end may or may not be valid
                // this is due to the way we select pivot
                // if there are two elements left, we choose the first one
                return start;
            }
        }

        // More than one row left
        int pivot = (start + end) / 2;
        if (target == matrix[pivot][0]) {
            return -2;
        } else if (target < matrix[pivot][0]) {
            return searchColumn(matrix, target, start, pivot-1);
        } else if (target > matrix[pivot][0] && target < matrix[pivot+1][0]) {
            return pivot;
        } else {
            return searchColumn(matrix, target, pivot+1, end);
        }
    }

    private boolean searchRow(int[] row, int target, int start, int end) {
        if (start >= end) {
            if (target == row[start]) {
                return true;
            } else {
                return false;
            }
        }

        int pivot = (start + end) / 2;
        if (target == row[pivot]) {
            return true;
        } else if (target < row[pivot]) {
            return searchRow(row, target, start, pivot-1);
        } else {
            return searchRow(row, target, pivot+1, end);
        }
    }
}
