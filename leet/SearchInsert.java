package leet;

public class SearchInsert {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 5, 6};
        int target = 5;
        int result = searchInsert(A, target);
        System.out.println(result);
    }

    public static int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }
        return searchInsertHelper(A, target, 0, A.length-1);
    }

    private static int searchInsertHelper(int[] A, int target, int start, int end) {
        System.out.println(start + " " + end);
        if (start >= end) {
            if (A[start] >= target) {
                return start;
            } else {
                return start + 1;
            }
        }

        int pivot = (start + start) / 2;
        if (A[pivot] == target) {
            return pivot;
        } else if (A[pivot] > target) {
            return searchInsertHelper(A, target, start, pivot-1);
        } else {
            return searchInsertHelper(A, target, pivot+1, end);
        }
    }
}
