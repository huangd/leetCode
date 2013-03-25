package leetcode;

/**
 * User: huangd
 * Date: 12/27/12
 * Time: 9:05 PM
 */
public class SearchInRotatedSortedArray {

    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int from = 0;
        int to = A.length;
        while (from < to) {
            int mid = (from + to) / 2;
            if (A[mid] == target) {
                return mid;
            } else {
                if (A[mid] > A[to - 1]) {
                    if (A[from] <= target && target < A[mid]) {
                        to = mid;
                    } else {
                        from = mid + 1;
                    }
                } else {
                    if (A[mid] < target && target <= A[to - 1]) {
                        from = mid + 1;
                    } else {
                        to = mid;
                    }
                }
            }
        }
        return -1;
    }
}
