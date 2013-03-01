package leetcode;

/**
 * User: huangd
 * Date: 2/28/13
 * Time: 9:45 PM
 */
public class SearchForARange {

    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lower = getLowerBound(A, target, 0, A.length);
        if (lower == -1) {
            return new int[]{-1, -1};
        } else {
            int upper = getUpperBound(A, target, 0, A.length);
            return new int[]{lower, upper};
        }
    }

    private int getLowerBound(int[] A, int target, int from, int to) {
        while (from < to) {
            int mid = (from + to) / 2;
            if (A[mid] < target) {
                from = mid + 1;
            } else {
                to = mid;
            }
        }
        if (from < A.length && A[from] == target) {
            return from;
        } else {
            return -1;
        }
    }

    private int getUpperBound(int[] A, int target, int from, int to) {
        while (from < to) {
            int mid = (from + to) / 2;
            if (A[mid] > target) {
                to = mid;
            } else {
                from = mid + 1;
            }
        }
        return from - 1;
    }
}
