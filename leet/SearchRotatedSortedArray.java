package leet;

public class SearchRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        return searchHelper(A, target, 0, A.length-1);
    }

    private int searchHelper(int[] A, int target, int start, int end) {
        if (start >= end) {
            if (target == A[start]) {
                return start;
            } else {
                return -1;
            }
        }

        int pivot = (start + end) / 2;
        if (target == A[pivot]) {
            return pivot;
        } else if (A[pivot] <= A[end]) {
            if (target > A[pivot] && target <= A[end]) {
                return searchHelper(A, target, pivot+1, end);
            } else {
                return searchHelper(A, target, start, pivot-1);
            }
        } else {
            if (target < A[pivot] && target >= A[start]) {
                return searchHelper(A, target, start, pivot-1);
            } else {
                return searchHelper(A, target, pivot+1, end);
            }
        }
    }
}
