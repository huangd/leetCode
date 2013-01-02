package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 9:05 PM
 */
public class SearchInRotatedSortedArray {
    private int[] A;
    private int target;

    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.A = A;
        this.target = target;
        return search(0, A.length);
    }

    private int search(int from, int to) {
        int mid = (to - from) / 2 + from;
        if (A[mid] == target) {
            return mid;
        } else if (from + 1 == to) {
            return -1;
        } else {
            if (A[mid] > A[to - 1]) {
                if (A[from] <= target && target < A[mid]) {
                    return search(from, mid);
                } else {
                    return search(mid + 1, to);
                }
            } else {
                if (A[mid] < target && target <= A[to - 1]) {
                    return search(mid + 1, to);
                } else {
                    return search(from, mid);
                }
            }
        }
    }
}
