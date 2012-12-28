package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 9:07 PM
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return binarySearch(A, 0, A.length, target);
    }

    private int binarySearch(int[] A, int start, int end, int target) {
        if (start >= end) {
            return start;
        } else {
            int mid = (end - start) / 2 + start;
            if (A[mid] == target) {
                return mid;
            } else if (target > A[mid]) {
                return binarySearch(A, mid + 1, end, target);
            } else {
                return binarySearch(A, start, mid, target);
            }
        }
    }
}
